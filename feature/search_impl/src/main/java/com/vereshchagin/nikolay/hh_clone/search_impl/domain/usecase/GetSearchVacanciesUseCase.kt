package com.vereshchagin.nikolay.hh_clone.search_impl.domain.usecase

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchVacanciesUseCase @Inject constructor(
    private val repository: HeadHunterRepository
) {

    suspend operator fun invoke(): Flow<List<Vacancy>> {
        return repository.allVacancies()
    }
}