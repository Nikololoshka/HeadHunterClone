package com.vereshchagin.nikolay.core.data.db.entites

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancy_entities")
data class VacancyEntity(
    @PrimaryKey val id: String,
    val lookingNumber: Int,
    val title: String,
    @Embedded val address: VacancyAddressEntity,
    val company: String,
    @Embedded val salary: VacancySalaryEntity,
    @Embedded val experience: VacancyExperiencesEntity,
    val publishedDate: String,
    val isFavorite: Boolean,
)

data class VacancyAddressEntity(
    val town: String,
    val street: String,
    val house: String
)

data class VacancyExperiencesEntity(
    val previewText: String,
    val text: String
)

data class VacancySalaryEntity(
    val short: String?,
    val full: String
)