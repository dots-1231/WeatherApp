package com.example.weatherapp.weather.domain.weather

import com.example.weatherapp.weather.data.weather.WeatherResponse

interface WeatherClient {

    fun getWeather(
        location: String,
        includeAirQuality: Boolean = false
    ): WeatherResponse
}