package com.example.weatherapp.home.domain.weather

import com.example.weatherapp.home.data.weather.WeatherResponse

interface WeatherClient {

    suspend fun getWeather(
        location: String,
        includeAirQuality: Boolean = false
    ): WeatherResponse
}