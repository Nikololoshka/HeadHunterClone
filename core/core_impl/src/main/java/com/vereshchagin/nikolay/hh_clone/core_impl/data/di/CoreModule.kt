package com.vereshchagin.nikolay.hh_clone.core_impl.data.di

import com.vereshchagin.nikolay.hh_clone.core_impl.data.repository.HeadHunterRepositoryImpl
import com.vereshchagin.nikolay.hh_clone.core_api.domain.repository.HeadHunterRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun provideHeadHunterRepository(repository: HeadHunterRepositoryImpl): HeadHunterRepository
}