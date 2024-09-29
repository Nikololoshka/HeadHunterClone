package com.vereshchagin.nikolay.favorite_impl.domain.usecase

import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import javax.inject.Inject

class GetFavoriteVacanciesUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {
    suspend operator fun invoke(): List<Vacancy> {
        val data = repository.fetchData()
        return data.vacancies.filter { it.isFavorite }
    }
}