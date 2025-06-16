package com.example.weather.ViewModel

data class WeatherUiModel(
    val currentWeather: CurrentWeather,
    val hourlyWeather: hourlyUiWeather
)

data class CurrentWeather(
    val temperature: Double,
    val isDay: Int,
    val currentTime: String,
    val weatherCode: Int,
    val rain: Double
)

data class hourlyUiWeather(
    val time: List<String>,
    val temperature: List<Double>
)
