package com.example.weatherapp.android.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.home.domain.weather.Weather
import com.example.weatherapp.home.presentation.HomeEvent
import com.example.weatherapp.home.presentation.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidHomeViewModel @Inject constructor(
    private val weather: Weather
) : ViewModel(){

    private val viewModel by lazy {
        HomeViewModel(weather, viewModelScope)
    }

    val state = viewModel.state

    fun onEvent(event: HomeEvent) {
        viewModel.onEvent(event)
    }
}