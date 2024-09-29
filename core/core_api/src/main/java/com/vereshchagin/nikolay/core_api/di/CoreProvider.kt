package com.vereshchagin.nikolay.core_api.di

import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRepository

interface CoreProvider {

    fun provideVacanciesRepository(): HeadHunterRepository
}