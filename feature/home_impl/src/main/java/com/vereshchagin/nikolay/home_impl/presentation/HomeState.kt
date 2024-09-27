package com.vereshchagin.nikolay.home_impl.presentation

import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem

data class HomeState(
    val items: List<HomeItem>
)