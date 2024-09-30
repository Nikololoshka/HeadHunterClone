package com.vereshchagin.nikolay.hh_clone.core_impl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.entites.RecommendationEntity
import com.vereshchagin.nikolay.hh_clone.core_impl.data.db.entites.VacancyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeadHunterDao {

    @Query("SELECT * FROM recommendation_entities")
    fun getAllRecommendations(): Flow<List<RecommendationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommendations(entities: List<RecommendationEntity>)

    @Query("SELECT COUNT(*) FROM vacancy_entities")
    fun vacanciesCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM vacancy_entities WHERE isFavorite")
    fun favoriteVacanciesCount(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancies(entities: List<VacancyEntity>)

    @Query("SELECT * FROM vacancy_entities WHERE id = :id LIMIT 1")
    suspend fun getVacancy(id: String): VacancyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(entity: VacancyEntity)

    @Query("SELECT * FROM vacancy_entities ORDER BY publishedDate DESC")
    fun getAllVacancies(): Flow<List<VacancyEntity>>

    @Query("SELECT * FROM vacancy_entities ORDER BY publishedDate DESC LIMIT :count")
    fun getRelativeVacancies(count: Int): Flow<List<VacancyEntity>>

    @Query("SELECT * FROM vacancy_entities WHERE isFavorite")
    fun favoriteVacancies(): Flow<List<VacancyEntity>>

    @Transaction
    suspend fun makeFavoriteVacancy(id: String) {
        val entity = getVacancy(id) ?: return
        insertVacancy(entity.copy(isFavorite = !entity.isFavorite))
    }
}