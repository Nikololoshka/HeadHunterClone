package com.vereshchagin.nikolay.core.data.mapper

import com.vereshchagin.nikolay.core.data.db.entites.RecommendationButtonEntity
import com.vereshchagin.nikolay.core.data.db.entites.RecommendationEntity
import com.vereshchagin.nikolay.core.data.db.entites.VacancyAddressEntity
import com.vereshchagin.nikolay.core.data.db.entites.VacancyEntity
import com.vereshchagin.nikolay.core.data.db.entites.VacancyExperiencesEntity
import com.vereshchagin.nikolay.core.data.db.entites.VacancySalaryEntity
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.RecommendationButton
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.core_api.domain.model.VacancyAddress
import com.vereshchagin.nikolay.core_api.domain.model.VacancyExperience
import com.vereshchagin.nikolay.core_api.domain.model.VacancySalary

fun VacancyEntity.toVacancy(): Vacancy {
    return Vacancy(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = VacancyAddress(
            town = address.town,
            street = address.street,
            house = address.house
        ),
        company = company,
        experience = VacancyExperience(
            previewText = experience.previewText,
            text = experience.text
        ),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = VacancySalary(
            short = salary.short,
            full = salary.full
        ),
        schedules = emptyList(),
        appliedNumber = 0,
        description = "",
        responsibilities = "",
        questions = emptyList()
    )
}

fun Vacancy.toEntity(): VacancyEntity {
    return VacancyEntity(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = VacancyAddressEntity(
            town = address.town,
            street = address.street,
            house = address.house
        ),
        company = company,
        experience = VacancyExperiencesEntity(
            previewText = experience.previewText,
            text = experience.text
        ),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = VacancySalaryEntity(
            short = salary.short,
            full = salary.full
        ),
    )
}

fun Recommendation.toEntity(): RecommendationEntity {
    return RecommendationEntity(
        id = id ?: "other",
        title = title,
        link = link,
        button = button?.let { RecommendationButtonEntity(text = it.text) }
    )
}

fun RecommendationEntity.toRecommendation(): Recommendation {
    return Recommendation(
        id = id,
        title = title,
        link = link,
        button = button?.let { RecommendationButton(text = it.text) }
    )
}