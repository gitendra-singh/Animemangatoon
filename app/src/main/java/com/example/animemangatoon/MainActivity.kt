package com.example.animemangatoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.animemangatoon.local.AppDatabase
import com.example.animemangatoon.local.FavoriteRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = AppDatabase.getDatabase(applicationContext)
        val favoriteRepository = FavoriteRepository(database.favoriteWebtoonDao())
        enableEdgeToEdge()
        setContent {
            AppNavigation(favoriteRepository = favoriteRepository)
        }
    }
}

