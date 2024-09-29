package com.vereshchagin.nikolay.favorite_impl.presentation

import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

data class FavariteState(
    val favorites: List<Vacancy>
)