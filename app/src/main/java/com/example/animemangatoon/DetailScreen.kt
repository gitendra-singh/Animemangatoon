package com.example.animemangatoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animemangatoon.local.FavoriteRepository
import com.example.animemangatoon.local.FavoriteWebtoon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(index: Int, favoriteRepository: FavoriteRepository, navController : NavController) {
    val titles = stringArrayResource(id = R.array.title)
    val longDescriptions = stringArrayResource(id = R.array.longDescription)
    val imageResources = listOf(
        R.drawable._detail_solo_leveling,
        R.drawable._details_tower_of_god,
        R.drawable._detail_leveling_warrior_manga,
        R.drawable.__noblesse_anime_visual,
        R.drawable.__details_the_god
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimeMangaToon") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("favorites")
                    }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorites",
                            modifier = Modifier
                                .graphicsLayer {
                                    scaleX = 1.5f
                                    scaleY = 1.5f
                                }
                        )
                    }
                }
            )
        }
    ){innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = titles[index],
                            style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.size(32.dp))
                        Image(
                            painter = painterResource(id = imageResources[index]),
                            contentDescription = "image",
                            modifier = Modifier

                        )
                        Spacer(modifier = Modifier.size(32.dp))
                        Text(text = "Description",
                            style = MaterialTheme.typography.headlineSmall)
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(text = longDescriptions[index])
                        Spacer(modifier = Modifier.size(32.dp))
                        Button(onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                favoriteRepository.addFavorite(
                                    FavoriteWebtoon(
                                        id = index,
                                        title = titles[index],
                                        description = longDescriptions[index],
                                        imageRes = imageResources[index]
                                    )
                                )
                            }
                        }) {
                            Text(text = "Add to Favorites"
                            )
                        }
                    }
                }

            }
        }
    }

}
