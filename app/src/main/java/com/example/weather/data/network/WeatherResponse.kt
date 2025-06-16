package com.example.weather.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    @SerialName("generationtime_ms") val generationTimeMs: Double,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int,
    val timezone: String,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String,
    val elevation: Double,
    @SerialName("current_units") val currentUnits: CurrentUnits,
    val current: CurrentWeather,
    @SerialName("hourly_units") val hourlyUnits: HourlyUnits,
    val hourly: HourlyWeather,
    @SerialName("daily_units") val dailyUnits: DailyUnits,
    val daily: DailyWeather
)

@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,
    @SerialName("temperature_2m") val temperature2m: String,
    @SerialName("is_day") val isDay: String
)

@Serializable
data class CurrentWeather(
    val time: String,
    val interval: Int,
    @SerialName("temperature_2m") val temperature2m: Double,
    @SerialName("is_day") val isDay: Int,
    val rain: Double,
    @SerialName("weather_code") val code: Int
)

@Serializable
data class HourlyUnits(
    val time: String,
    @SerialName("temperature_2m") val temperature2m: String,
)

@Serializable
data class HourlyWeather(
    val time: List<String>,
    @SerialName("temperature_2m") val temperature2m: List<Double>,
    val rain: List<Double>,
    @SerialName("weather_code") val code: List<Int>
)

@Serializable
data class DailyUnits(
    val time: String,
    @SerialName("temperature_2m_max") val temperature2mMax: String,
    @SerialName("temperature_2m_min") val temperature2mMin: String
)

@Serializable
data class DailyWeather(
    val time: List<String>,
    @SerialName("temperature_2m_max") val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min") val temperature2mMin: List<Double>
)
