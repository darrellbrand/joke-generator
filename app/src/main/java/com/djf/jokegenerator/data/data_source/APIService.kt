package com.djf.jokegenerator.data.data_source

import com.djf.jokegenerator.domain.util.Joke

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("random")
    suspend fun getRandomJoke(): Response<Joke>
}