package com.vereshchagin.nikolay.hh_clone.domain.usecase

import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteVacanciesCountUseCase @Inject constructor(
    private val repository: HeadHunterRepository
) {

    operator fun invoke(): Flow<Int> {
        return repository.favoriteVacanciesCount()
    }
}