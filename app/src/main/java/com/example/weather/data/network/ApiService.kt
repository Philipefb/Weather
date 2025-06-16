package com.example.weather.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.open-meteo.com/v1/forecast?latitude=-21.5956&longitude=-46.8886&daily=temperature_2m_max,temperature_2m_min&hourly=temperature_2m,rain,weather_code,relative_humidity_2m&current=temperature_2m,is_day&timezone=America%2FSao_Paulo
interface ApiService {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("hourly") hourly: String = "temperature_2m,rain,weather_code,relative_humidity_2m",
        @Query("current") current: String = "temperature_2m,is_day,weather_code,rain",
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min",
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponse
}