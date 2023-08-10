package com.example.weatherapp.home.presentation

import com.example.weatherapp.home.data.weather.WeatherResponse

data class HomeState(
    val location: String = "",
    val weatherDataModel: WeatherResponse? = null
)