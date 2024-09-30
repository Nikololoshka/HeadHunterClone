package com.vereshchagin.nikolay.hh_clone.core_impl.data.repository

import com.vereshchagin.nikolay.hh_clone.core_impl.data.api.HeadHunterApi
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.dao.HeadHunterDao
import com.vereshchagin.nikolay.hh_clone.core_impl.data.mapper.toData
import com.vereshchagin.nikolay.hh_clone.core_impl.data.mapper.toEntity
import com.vereshchagin.nikolay.hh_clone.core_impl.data.mapper.toRecommendation
import com.vereshchagin.nikolay.hh_clone.core_impl.data.mapper.toVacancy
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val END_POINT =
    "https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download"

class HeadHunterRepositoryImpl @Inject constructor(
    private val api: HeadHunterApi,
    private val dao: HeadHunterDao
) : HeadHunterRepository {

    private val mutex = Mutex()

    override suspend fun allVacancies(): Flow<List<Vacancy>> {
        checkCache()

        return dao
            .getAllVacancies()
            .map { items -> items.map { item -> item.toVacancy() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun allRecommendations(): Flow<List<Recommendation>> {
        checkCache()

        return dao
            .getAllRecommendations()
            .map { items -> items.map { item -> item.toRecommendation() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun relativeVacancies(count: Int): Flow<List<Vacancy>> {
        checkCache()

        return dao
            .getRelativeVacancies(count)
            .map { items -> items.map { item -> item.toVacancy() } }
            .flowOn(Dispatchers.IO)
    }

    private suspend fun checkCache() = mutex.withLock {
        withContext(Dispatchers.IO) {
            if (dao.vacanciesCount().first() <= 0) {
                val data = api.fetch(END_POINT).toData()

                val vacancies = data.vacancies.map { item -> item.toEntity() }
                dao.insertVacancies(vacancies)

                val recommendations = data.recommendations.map { item -> item.toEntity() }
                dao.insertRecommendations(recommendations)
            }
        }
    }

    override fun favoriteVacanciesCount(): Flow<Int> {
        return dao.favoriteVacanciesCount()
    }

    override suspend fun vacanciesCount(): Flow<Int> {
        return dao.vacanciesCount()
    }

    override fun favoriteVacancies(): Flow<List<Vacancy>> {
        return dao
            .favoriteVacancies()
            .map { items -> items.map { item -> item.toVacancy() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun makeFavoriteVacancy(id: String) = withContext(Dispatchers.IO) {
        dao.makeFavoriteVacancy(id)
    }
}