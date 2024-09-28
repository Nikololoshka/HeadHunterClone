package com.vereshchagin.nikolay.core_api.domain.model

data class Recommendation(
    val id: String?,
    val title: String,
    val link: String,
    val button: RecommendationButton?
)

data class RecommendationButton(
    val text: String
)