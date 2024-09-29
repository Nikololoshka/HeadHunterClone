package com.vereshchagin.nikolay.search_impl.domain.interceptor

import com.vereshchagin.nikolay.search_impl.domain.usecase.GetSearchVacanciesUseCase
import com.vereshchagin.nikolay.search_impl.domain.usecase.SetFavoriteVacancyUseCase
import javax.inject.Inject

class SearchVacanciesInterceptor @Inject constructor(
    private val searchVacanciesUseCase: GetSearchVacanciesUseCase,
    private val setFavoriteVacancyUseCase: SetFavoriteVacancyUseCase
) {
    suspend fun vacancies() = searchVacanciesUseCase()

    suspend fun setFavoriteVacancy(id: String) = setFavoriteVacancyUseCase(id)
}