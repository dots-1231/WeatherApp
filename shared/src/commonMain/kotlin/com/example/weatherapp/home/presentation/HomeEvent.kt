package com.example.weatherapp.home.presentation

import com.example.weatherapp.home.data.weather.Location

sealed interface HomeEvent {
    class FetchWeather(val location: String) : HomeEvent
}