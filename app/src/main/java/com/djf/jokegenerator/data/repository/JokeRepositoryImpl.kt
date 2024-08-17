package com.djf.jokegenerator.data.repository

import com.djf.jokegenerator.data.data_source.APIService
import com.djf.jokegenerator.domain.repository.JokeRepository
import com.djf.jokegenerator.domain.util.Joke

class JokeRepositoryImpl(private val apiService: APIService) : JokeRepository {

    override suspend fun getJoke(): Joke? {
        try {
            val res = apiService.getRandomJoke()
            if (res.isSuccessful) {
                val body = res.body()
                body?.let {
                    return Joke(icon_url = body.icon_url, url = body.url, value = body.value)
                }
            }
        } catch (e: Exception) {
            println("Jokerepo exception" + e.message)
        }
        return null
    }
}