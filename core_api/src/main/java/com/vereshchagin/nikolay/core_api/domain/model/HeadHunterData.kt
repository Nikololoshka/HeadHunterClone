package com.vereshchagin.nikolay.core_api.domain.model

data class HeadHunterData(
    val recommendations: List<Recommendation>,
    val vacancies: List<Vacancy>
)