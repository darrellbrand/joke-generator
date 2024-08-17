package com.djf.jokegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.djf.jokegenerator.presentation.JokeScreen
import com.djf.jokegenerator.presentation.JokeViewModel
import com.djf.jokegenerator.ui.theme.JokeGeneratorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jokeViewModel : JokeViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            val joke = jokeViewModel.joke.collectAsState()
            JokeGeneratorTheme {
                JokeScreen(joke = joke) { jokeViewModel.getRandomJoke() }
            }
        }
    }
}
