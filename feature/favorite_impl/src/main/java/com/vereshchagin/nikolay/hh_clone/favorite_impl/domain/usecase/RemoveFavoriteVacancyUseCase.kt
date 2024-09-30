package com.vereshchagin.nikolay.hh_clone.favorite_impl.domain.usecase

import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import javax.inject.Inject

class RemoveFavoriteVacancyUseCase @Inject constructor(
    private val repository: HeadHunterRepository
) {

    suspend operator fun invoke(id: String) {
        return repository.makeFavoriteVacancy(id)
    }
}