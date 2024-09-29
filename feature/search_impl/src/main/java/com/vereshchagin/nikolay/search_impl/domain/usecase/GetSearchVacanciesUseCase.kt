package com.vereshchagin.nikolay.search_impl.domain.usecase

import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import javax.inject.Inject

class GetSearchVacanciesUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {

    suspend operator fun invoke(): List<Vacancy> {
        val data = repository.fetchData()
        return data.vacancies
    }
}