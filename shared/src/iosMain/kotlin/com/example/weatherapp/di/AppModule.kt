package com.example.weatherapp.di

import com.example.weatherapp.home.data.remote.HttpClientFactory
import com.example.weatherapp.home.data.weather.KtorWeatherClient
import com.example.weatherapp.home.domain.weather.Weather
import com.example.weatherapp.home.domain.weather.WeatherClient

object AppModule {

    private val weatherClient: WeatherClient by lazy {
        KtorWeatherClient(
            HttpClientFactory().create()
        )
    }

    val weatherUseCase: Weather by lazy {
        Weather(weatherClient)
    }
}