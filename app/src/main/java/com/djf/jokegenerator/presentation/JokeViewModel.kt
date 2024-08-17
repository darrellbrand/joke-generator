package com.djf.jokegenerator.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.djf.jokegenerator.domain.usecase.JokeUseCase
import com.djf.jokegenerator.domain.util.Joke
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(val jokeUseCase: JokeUseCase) : ViewModel() {

    private val _joke = MutableStateFlow(Joke())
    val joke = _joke.asStateFlow()

    init {
        getRandomJoke()
    }


    fun getRandomJoke() {
        viewModelScope.launch {
            val joke = jokeUseCase.getRandomJoke()
            joke?.let {
                _joke.update { joke }
                println("JOKE= " + joke.value)
            }
        }
    }

}