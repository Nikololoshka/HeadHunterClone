package com.vereshchagin.nikolay.home_impl.domain.model

import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

data class HomeData(
    val recommendations: List<com.vereshchagin.nikolay.core_api.domain.model.Recommendation>,
    val vacancies: List<com.vereshchagin.nikolay.core_api.domain.model.Vacancy>
)