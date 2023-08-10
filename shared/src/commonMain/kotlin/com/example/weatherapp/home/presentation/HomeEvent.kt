package com.example.weatherapp.home.presentation

import com.example.weatherapp.home.data.weather.Location

sealed class HomeEvent {
    data class FetchWeather(val location: String) : HomeEvent()
}