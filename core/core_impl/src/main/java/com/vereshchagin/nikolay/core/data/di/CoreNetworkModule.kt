package com.vereshchagin.nikolay.core.data.di

import com.google.gson.GsonBuilder
import com.vereshchagin.nikolay.core.data.api.HeadHunterApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreNetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .create()
                )
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideHeadHunterApi(retrofit: Retrofit): HeadHunterApi {
        return retrofit.create(HeadHunterApi::class.java)
    }
}