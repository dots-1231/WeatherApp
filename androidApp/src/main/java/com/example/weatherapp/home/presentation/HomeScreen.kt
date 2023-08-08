package com.example.weatherapp.home.presentation

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

@Composable
fun HomeScreen() {
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
            item { SearchBar() }
            item { WeatherCard() }
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
    modifier: Modifier = Modifier
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
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun WeatherCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            WeatherCardLabel(label = "Burke, VA", value = "56 Fahrenheit")
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
        text = "Burke, VA",
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    Row {
        Text(text = "Temperature: ", fontWeight = SemiBold)
        Text(text = "56 Fahrenheit")
    }
}