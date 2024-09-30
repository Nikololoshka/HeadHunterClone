package com.vereshchagin.nikolay.hh_clone.favorite_impl.domain.interceptor

import com.vereshchagin.nikolay.hh_clone.favorite_impl.domain.usecase.GetFavoriteVacanciesUseCase
import com.vereshchagin.nikolay.hh_clone.favorite_impl.domain.usecase.RemoveFavoriteVacancyUseCase
import javax.inject.Inject

class FavoriteInterceptor @Inject constructor(
    private val favoriteVacanciesUseCase: GetFavoriteVacanciesUseCase,
    private val removeFavoriteVacancyUseCase: RemoveFavoriteVacancyUseCase
) {

    fun favoriteVacancies() = favoriteVacanciesUseCase()

    suspend fun setFavoriteVacancy(id: String) = removeFavoriteVacancyUseCase(id)
}