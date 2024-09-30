package com.vereshchagin.nikolay.hh_clone.core_impl.data.di

import android.content.Context
import androidx.room.Room
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.HeadHunterDatabase
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.dao.HeadHunterDao
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