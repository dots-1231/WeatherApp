package com.example.weatherapp.android.home.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import com.example.weatherapp.home.presentation.HomeEvent
import com.example.weatherapp.home.presentation.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = {}
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { SearchBar(onEvent) }
            item {
                WeatherCard(
                    locationName = state.weatherDataModel?.location?.name ?: "No name",
                    locationTemperature = state.weatherDataModel?.currentWeather?.feelsLikeFahrenheit.toString()
                )
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        title = { Text(text = "Multiplatform Weather App") }
    )
}

@Composable
fun SearchLabel() {
    Text(text = "Enter a city or zipcode")
}

@Composable
fun SearchBar(
    onEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val textFieldValue = remember {
        mutableStateOf("")
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextField(
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it },
            placeholder = { SearchLabel() }
        )
        Spacer(modifier = Modifier.weight(1.0f))
        Button(
            onClick = {
                Log.d("yolo", "text field clicked - ${textFieldValue.value}")
                onEvent(HomeEvent.FetchWeather(textFieldValue.value))
            }
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun WeatherCard(
    locationName: String,
    locationTemperature: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            WeatherCardLabel(label = locationName, value = "$locationTemperature Fahrenheit")
        }
    }
}

@Composable
fun WeatherCardLabel(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = label,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    Row {
        Text(text = "Temperature: ", fontWeight = SemiBold)
        Text(text = value)
    }
}