package com.example.weatherapp.home.domain.weather

import com.example.weatherapp.core.domain.util.Resource
import com.example.weatherapp.home.data.weather.WeatherResponse

class Weather(
    private val client: WeatherClient
) {

    suspend fun execute(
        location: String,
        includeAirQuality: Boolean = false
    ) : Resource<WeatherResponse> {
        return try {
            val weatherResponse = client.getWeather(location, includeAirQuality)

            Resource.Success(weatherResponse)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}