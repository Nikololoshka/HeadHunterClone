package com.vereshchagin.nikolay.core_api.di

import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource

interface CoreProvider {

    fun provideHeadHunterRemoteSource(): HeadHunterRemoteSource
}