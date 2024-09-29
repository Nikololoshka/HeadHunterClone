package com.vereshchagin.nikolay.core.data.di

import com.vereshchagin.nikolay.core.data.repository.HeadHunterRepositoryImpl
import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun provideHeadHunterRepository(repository: HeadHunterRepositoryImpl): HeadHunterRepository
}