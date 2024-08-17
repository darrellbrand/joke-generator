package com.djf.jokegenerator.di

import com.djf.jokegenerator.data.data_source.APIService
import com.djf.jokegenerator.data.repository.JokeRepositoryImpl
import com.djf.jokegenerator.domain.repository.JokeRepository
import com.djf.jokegenerator.domain.usecase.JokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun provideJokeRepository(apiService: APIService): JokeRepository {
        return JokeRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideJokeUseCase(jokeRepository: JokeRepository): JokeUseCase {
        return JokeUseCase(jokeRepository)
    }
}