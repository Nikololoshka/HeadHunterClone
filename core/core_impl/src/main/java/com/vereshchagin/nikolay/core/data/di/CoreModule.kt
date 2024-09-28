package com.vereshchagin.nikolay.core.data.di

import com.vereshchagin.nikolay.core.data.repository.HeadHunterRemoteSourceImpl
import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import dagger.Binds
import dagger.Module

@Module
interface CoreModule {

    @Binds
    fun provideHeadHunterSource(sourceImpl: HeadHunterRemoteSourceImpl): HeadHunterRemoteSource
}