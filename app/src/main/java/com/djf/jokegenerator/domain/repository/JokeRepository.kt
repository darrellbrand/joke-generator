package com.djf.jokegenerator.domain.repository

import com.djf.jokegenerator.data.data_source.APIService
import com.djf.jokegenerator.domain.util.Joke

interface JokeRepository {
    suspend fun getJoke() : Joke?
}