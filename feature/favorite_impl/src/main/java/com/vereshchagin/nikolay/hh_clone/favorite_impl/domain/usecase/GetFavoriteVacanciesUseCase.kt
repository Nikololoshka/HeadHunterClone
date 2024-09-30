package com.vereshchagin.nikolay.hh_clone.favorite_impl.domain.usecase

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteVacanciesUseCase @Inject constructor(
    private val repository: HeadHunterRepository
) {
    operator fun invoke(): Flow<List<Vacancy>> {
        return repository.favoriteVacancies()
    }
}