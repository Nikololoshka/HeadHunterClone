package com.vereshchagin.nikolay.core.data.db.entites

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "recommendation_entities",)
data class RecommendationEntity(
    @PrimaryKey val id: String,
    val title: String,
    val link: String,
    @Embedded val button: RecommendationButtonEntity?
)

data class RecommendationButtonEntity(
    val text: String
)