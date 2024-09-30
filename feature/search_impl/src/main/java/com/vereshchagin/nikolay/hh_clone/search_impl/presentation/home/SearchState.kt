package com.vereshchagin.nikolay.hh_clone.search_impl.presentation.home

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy

data class SearchState(
    val recommendations: List<Recommendation>,
    val vacancies: List<Vacancy>,
    val moreVacancies: Int
)