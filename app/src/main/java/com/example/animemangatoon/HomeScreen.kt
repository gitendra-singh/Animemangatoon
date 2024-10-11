package com.example.animemangatoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val titles = stringArrayResource(id = R.array.title)
    val shortDescription = stringArrayResource(id = R.array.shortDescription)
    val imageResources = listOf(
        R.drawable.solo_leveling,
        R.drawable.tower_of_god2,
        R.drawable.hard_levelign_warrior_750x375_3,
        R.drawable.noblesse_750x375_4,
        R.drawable.the_god_of_school_5
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimeMangaToon") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
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
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(titles.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = titles[index],
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate("detail/$index")
                                })
                        Image(
                            painter = painterResource(id = imageResources[index]),
                            contentDescription = "image",
                            modifier = Modifier
                                .size(200.dp)

                        )
                        Text(text = shortDescription[index])
                    }
                }
            }
        }
    }
}

