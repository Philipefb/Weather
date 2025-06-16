package com.example.weather.ui.screen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ViewModel.CurrentWeather
import com.example.weather.ui.screen.getWeatherDescription
import com.example.weather.ui.screen.getWeatherIcon
import java.util.Locale

@Composable
fun CurrentTemperatureSection(current: CurrentWeather) {
    val temperaturaFormatada = String.format(Locale("pt", "BR"), "%.1f", current.temperature)
    val descClima = getWeatherDescription(current.weatherCode)
    val icClima = getWeatherIcon(current.weatherCode)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("${temperaturaFormatada}°" , fontSize = 64.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id = icClima), contentDescription = null,   modifier = Modifier.size(96.dp))
    }

    Text(descClima, color = Color.LightGray, fontSize = 18.sp)
    Spacer(modifier = Modifier.height(8.dp))
}