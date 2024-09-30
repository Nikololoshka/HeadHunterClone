package com.vereshchagin.nikolay.hh_clone.search_impl.presentation.vacancies

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy

data class SearchVacanciesState(
    val vacancies: List<Vacancy>
)