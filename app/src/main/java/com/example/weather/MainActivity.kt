package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.weather.ViewModel.WeatherViewModel
import com.example.weather.data.repository.WeatherRepository
import com.example.weather.ui.screen.MainScreen
import com.example.weather.ui.theme.WeatherTheme



class MainActivity : ComponentActivity() {

    private val weatherViewModel by viewModels<WeatherViewModel> {   WeatherViewModel.provideFactory(WeatherRepository())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WeatherTheme {
                MainScreen(weatherViewModel)
                }
            }
        }
    }
