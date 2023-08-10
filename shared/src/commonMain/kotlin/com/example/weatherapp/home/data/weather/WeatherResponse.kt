package com.example.weatherapp.home.data.weather

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherResponse(
    val location: Location,
    @SerialName("current") val currentWeather: Weather
)

@kotlinx.serialization.Serializable
data class Location(
    val name: String,
    val region: String,
    val country: String,
    @SerialName("lat") val latitude: Double,
    @SerialName("lon") val longitude: Double,
    @SerialName("tz_id") val timeZoneId: String,
    @SerialName("localtime_epoch") val localTimeEpoch: Double,
    @SerialName("localtime") val localTime: String
)

@kotlinx.serialization.Serializable
data class Weather(
    @SerialName("last_updated_epoch") val lastUpdatedEpoch: Double,
    @SerialName("last_updated") val lastUpdated: String,
    @SerialName("temp_c") val temperatureCelsius: Double,
    @SerialName("temp_f") val temperatureFahrenheit: Double,
    @SerialName("is_day") val isDay: Int,
    val condition: Condition,
    @SerialName("wind_mph") val windMph: Double,
    @SerialName("wind_kph") val windKph: Double,
    @SerialName("wind_degree") val windDegree: Double,
    @SerialName("wind_dir") val windDirection: String,
    @SerialName("pressure_mb") val pressureMb: Double,
    @SerialName("pressure_in") val pressureIn: Double,
    @SerialName("precip_mm") val precipitationMm: Double,
    @SerialName("precip_in") val precipitationInches: Double,
    val humidity: Int,
    val cloud: Int,
    @SerialName("feelslike_c") val feelsLikeCelsius: Double,
    @SerialName("feelslike_f") val feelsLikeFahrenheit: Double,
    @SerialName("vis_km") val visibilityKilometers: Double,
    @SerialName("vis_miles") val visibilityMiles: Double,
    val uv: Double,
    @SerialName("gust_mph") val gustMph: Double,
    @SerialName("gust_kph") val gustKph: Double
)

@kotlinx.serialization.Serializable
data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)
