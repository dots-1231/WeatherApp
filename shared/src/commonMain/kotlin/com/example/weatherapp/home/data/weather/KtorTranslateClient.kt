package com.example.weatherapp.home.data.weather

import com.example.weatherapp.home.domain.weather.WeatherClient
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*

class KtorWeatherClient(
    private val httpClient: HttpClient
) : WeatherClient {

    override suspend fun getWeather(location: String, includeAirQuality: Boolean): WeatherResponse {
        val result = try {
            httpClient.get {
                url("https://api.weatherapi.com/v1/current.json")

                parameter("key", SecretData.API_KEY)
                if (includeAirQuality) parameter("aqi", "yes") else parameter("aqi", "no")
                parameter("q", location)
            }
        } catch (e: IOException) {
            println("request failed")
            throw Exception("Request failed")
        }

        return try {
            val body = result.body<WeatherResponse>()
            body
        } catch (e: Exception) {
            throw Exception("Request failed")
        }
    }
}