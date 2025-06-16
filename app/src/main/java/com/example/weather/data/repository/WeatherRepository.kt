package com.example.weather.data.repository

import android.util.Log
import com.example.weather.data.network.RetrofitClient
import com.example.weather.data.network.WeatherResponse
import com.google.gson.GsonBuilder

class WeatherRepository {

    suspend fun getWeatherData(): WeatherResponse {
        try {
            val response = RetrofitClient.api.getWeather(
                lat = -21.625,
                lon = -46.875
            )
//            val gson = GsonBuilder().setPrettyPrinting().create()
//            val json = gson.toJson(response)
//            logLargeString("RESPONSE_JSON", json)
            return response
        } catch (e: Exception) {
            println("Erro na requisição:")
            e.printStackTrace()
            throw e
        }
    }
}

// funcao criada apenas para visualizacao de logs
fun logLargeString(tag: String, content: String) {
    val chunkSize = 1000
    var start = 0
    while (start < content.length) {
        val end = minOf(start + chunkSize, content.length)
        Log.d(tag, content.substring(start, end))
        start += chunkSize
    }
}