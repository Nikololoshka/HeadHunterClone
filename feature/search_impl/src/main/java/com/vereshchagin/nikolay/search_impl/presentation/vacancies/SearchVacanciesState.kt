package com.vereshchagin.nikolay.search_impl.presentation.vacancies

import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

data class SearchVacanciesState(
    val vacancies: List<Vacancy>
)