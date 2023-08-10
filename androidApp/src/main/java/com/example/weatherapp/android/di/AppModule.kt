package com.example.weatherapp.android.di

import com.example.weatherapp.home.data.remote.HttpClientFactory
import com.example.weatherapp.home.data.weather.KtorWeatherClient
import com.example.weatherapp.home.domain.weather.Weather
import com.example.weatherapp.home.domain.weather.WeatherClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideWeatherClient(httpClient: HttpClient): WeatherClient {
        return KtorWeatherClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCase(client: WeatherClient): Weather {
        return Weather(client)
    }
}