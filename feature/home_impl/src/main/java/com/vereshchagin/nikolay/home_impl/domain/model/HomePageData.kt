package com.vereshchagin.nikolay.home_impl.domain.model

import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

data class HomePageData(
    val recommendations: List<Recommendation>,
    val vacancies: List<Vacancy>,
    val moreVacancies: Int
)