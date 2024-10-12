package com.example.animemangatoon.local

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(favoriteRepository: FavoriteRepository) {
    val favorites = remember {
        mutableListOf<FavoriteWebtoon>()
    }
    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            favorites.addAll(favoriteRepository.getFavorites())
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimeMangaToon") },

            )
        }
    ) { innerPadding ->
        LazyColumn( modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Box(modifier = Modifier
                    .padding(16.dp),
                    ){
                    Text(text = "Favorite Screen",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.secondary,
                        )
                }

            }
            items(favorites.size) { index ->
                val favorite = favorites[index]
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = favorite.title,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Image(
                            painter = painterResource(id = favorite.imageRes),
                            contentDescription = "image",
                            modifier = Modifier.size(200.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = "Description",
                            style = MaterialTheme.typography.headlineSmall)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = favorite.description)
                    }
                }
            }
        }
    }
}