package com.vereshchagin.nikolay.home_impl.presentation

import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.home_impl.domain.model.HomePageData

data class HomeState(
    val data: HomePageData
)