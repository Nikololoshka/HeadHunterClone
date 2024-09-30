package com.vereshchagin.nikolay.hh_clone.core_api.domain.model

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: VacancyAddress,
    val company: String,
    val experience: VacancyExperience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: VacancySalary,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

data class VacancyAddress(
    val town: String,
    val street: String,
    val house: String
)

data class VacancyExperience(
    val previewText: String,
    val text: String
)

data class VacancySalary(
    val short: String?,
    val full: String
)