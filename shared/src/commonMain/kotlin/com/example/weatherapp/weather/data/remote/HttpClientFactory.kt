package com.example.weatherapp.weather.data.remote

import io.ktor.client.*

expect class HttpClientFactory {

    fun create(): HttpClient
}