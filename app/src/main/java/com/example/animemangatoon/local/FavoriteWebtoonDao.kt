package com.example.animemangatoon.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteWebtoonDao {
    @Insert
    suspend fun addFavorite(webtoon:FavoriteWebtoon)

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites():List<FavoriteWebtoon>
}