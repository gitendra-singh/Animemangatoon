package com.example.animemangatoon.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteWebtoon(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val imageRes: Int
)
