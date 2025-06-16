package com.example.weather.ViewModel

import androidx.lifecycle.ViewModel
import com.example.weather.data.repository.WeatherRepository
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiModel?>(null)
    val uiState: StateFlow<WeatherUiModel?> = _uiState

    fun loadWeatherData() {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherData()
                val weatherUiModel = WeatherUiModel(
                    currentWeather = CurrentWeather(
                        temperature = response.current.temperature2m,
                        isDay = response.current.isDay,
                        currentTime = response.current.time,
                        weatherCode = response.current.code,
                        rain = response.current.rain
                    ),
                    hourlyWeather = hourlyUiWeather(
                        response.hourly.time,
                        response.hourly.temperature2m
                    )
                )

                _uiState.value = weatherUiModel
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    init {
        loadWeatherData()
    }

    companion object {
        fun provideFactory(repository: WeatherRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return WeatherViewModel(repository) as T
                }
            }
    }
}
