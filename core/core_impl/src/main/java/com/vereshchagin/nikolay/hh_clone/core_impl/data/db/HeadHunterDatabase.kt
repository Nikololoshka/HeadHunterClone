package com.vereshchagin.nikolay.hh_clone.core_impl.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.dao.HeadHunterDao
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.entites.RecommendationEntity
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.entites.VacancyEntity

@Database(
    entities = [
        VacancyEntity::class,
        RecommendationEntity::class
    ],
    version = 1
)
abstract class HeadHunterDatabase : RoomDatabase() {

    abstract fun headHunterDao(): HeadHunterDao
}