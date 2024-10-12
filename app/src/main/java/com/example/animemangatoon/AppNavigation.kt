package com.example.animemangatoon

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animemangatoon.local.FavoriteRepository
import com.example.animemangatoon.local.FavoriteScreen

@Composable
fun AppNavigation(favoriteRepository: FavoriteRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("detail/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
            DetailScreen(index = index, navController = navController, favoriteRepository = favoriteRepository)
        }
        composable("favorites") {
            FavoriteScreen(favoriteRepository = favoriteRepository)
        }
    }
}

