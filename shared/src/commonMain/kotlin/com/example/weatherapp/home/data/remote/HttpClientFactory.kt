package com.example.weatherapp.home.data.remote

import io.ktor.client.*

expect class HttpClientFactory {

    fun create(): HttpClient
}