package com.djf.jokegenerator.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.djf.jokegenerator.R
import com.djf.jokegenerator.domain.util.Joke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeScreen(joke: State<Joke>, onClick: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.padding(15.dp)) {
                        Text(text = "Chuck Norris")
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.purepng_com_chuck_norrischuck_norrischucknorriscarlos_ray_norrisamerican_martial_artistactorproducerscreenwriter_1701528022104fhdhh),
                            contentDescription = " chuck norris logo",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondary)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onClick() },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(Icons.Filled.Refresh, contentDescription = " get new joke")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.gettyimages_525603356_612x612),
                modifier = Modifier
                    .size(300.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 5.dp,
                        shape = RoundedCornerShape(15.dp),
                        color = Color.Black
                    ),
                contentDescription = "chuck norris pic",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier.padding(15.dp),
            ) {
                AnimatedContent(targetState = joke.value, label = "animated text") {
                    it.value?.let {
                        joke.value.value?.let { it1 ->
                            Text(
                                text = it1,
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier.padding(15.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}



