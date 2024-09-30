package com.vereshchagin.nikolay.hh_clone.core_api.domain.repository

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface HeadHunterRepository {

    suspend fun allVacancies(): Flow<List<Vacancy>>

    suspend fun allRecommendations(): Flow<List<Recommendation>>

    suspend fun relativeVacancies(count: Int = 3):  Flow<List<Vacancy>>

    suspend fun makeFavoriteVacancy(id: String)

    suspend fun vacanciesCount(): Flow<Int>

    fun favoriteVacancies(): Flow<List<Vacancy>>

    fun favoriteVacanciesCount(): Flow<Int>
}