package com.djf.jokegenerator.domain.usecase

import com.djf.jokegenerator.domain.repository.JokeRepository
import com.djf.jokegenerator.domain.util.Joke
import javax.inject.Inject

class JokeUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    suspend fun getRandomJoke() : Joke?{
        return jokeRepository.getJoke()
    }
}