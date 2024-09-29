package com.vereshchagin.nikolay.search_impl.domain.interceptor

import com.vereshchagin.nikolay.search_impl.domain.usecase.GetMoreVacanciesCountUseCase
import com.vereshchagin.nikolay.search_impl.domain.usecase.GetRecommendationsUseCase
import com.vereshchagin.nikolay.search_impl.domain.usecase.GetRelativeVacanciesUseCase
import com.vereshchagin.nikolay.search_impl.domain.usecase.SetFavoriteVacancyUseCase
import javax.inject.Inject

class SearchHomeDataInterceptor @Inject constructor(
    private val relativeVacanciesUseCase: GetRelativeVacanciesUseCase,
    private val recommendationsUseCase: GetRecommendationsUseCase,
    private val moreVacanciesCountUseCase: GetMoreVacanciesCountUseCase,
    private val setFavoriteVacancyUseCase: SetFavoriteVacancyUseCase
) {

    suspend fun relativeVacancies() = relativeVacanciesUseCase()

    suspend fun recommendations() = recommendationsUseCase()

    suspend fun moreVacanciesCount() = moreVacanciesCountUseCase()

    suspend fun setFavoriteVacancy(id: String) = setFavoriteVacancyUseCase(id)
}