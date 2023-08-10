package com.example.weatherapp.home.presentation

import com.example.weatherapp.core.domain.util.Resource
import com.example.weatherapp.core.domain.util.toCommonStateFlow
import com.example.weatherapp.home.domain.weather.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val weather: Weather,
    private val coroutineScope: CoroutineScope?
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(HomeState())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())
        .toCommonStateFlow()

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.FetchWeather -> {
                viewModelScope.launch {
                    val result = weather.execute(location = event.location)

                    when(result) {
                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    weatherDataModel = result.data
                                )
                            }
                        }
                        is Resource.Error -> Unit // add error handling
                    }
                }
            }
        }
    }

}