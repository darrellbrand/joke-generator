package com.djf.jokegenerator.domain.util

data class Joke(
    val icon_url: String? = "",
    val url: String? = "",
    val value: String? = ""
)

data class JokeResponse(val joke: Joke)