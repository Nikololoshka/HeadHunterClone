package com.vereshchagin.nikolay.core.data.di

import android.content.Context
import androidx.room.Room
import com.vereshchagin.nikolay.core.data.db.HeadHunterDatabase
import com.vereshchagin.nikolay.core.data.db.dao.HeadHunterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreDatabaseModule {

    @Singleton
    @Provides
    fun provideHeadHunterDatabase(context: Context): HeadHunterDatabase {
        return Room
            .databaseBuilder(context, HeadHunterDatabase::class.java, "vacancies_db")
            .build()
    }

    @Singleton
    @Provides
    fun provideHeadHunterDao(db: HeadHunterDatabase): HeadHunterDao {
        return db.headHunterDao()
    }
}