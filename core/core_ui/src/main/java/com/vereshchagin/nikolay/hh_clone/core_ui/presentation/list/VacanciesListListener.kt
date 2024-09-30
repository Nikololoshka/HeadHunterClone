package com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list

interface VacanciesListListener {
    fun onFavoriteClicked(id: String)
    fun onCardClicked(id: String)
}