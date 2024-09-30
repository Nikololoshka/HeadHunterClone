package com.vereshchagin.nikolay.hh_clone.core_api.di

import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository

interface CoreProvider {

    fun provideVacanciesRepository(): HeadHunterRepository
}