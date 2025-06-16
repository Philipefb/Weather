package com.example.weather.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.weather.R
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun TodayDateText() {
    val today = LocalDate.now()
    val dayOfMonth = today.dayOfMonth
    val month = today.month.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))
    val dayOfWeek = today.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))
    Text(
        text = "$dayOfMonth $month, $dayOfWeek",
        color = Color.LightGray,
        fontSize = 14.sp
    )
}

fun getWeatherDescription(code: Int): String {
    return when (code) {
        0 -> "Céu limpo ☀️"
        in 1..3 -> "Parcialmente nublado ou encoberto 🌤️☁️"
        45, 48 -> "Nevoeiro ou névoa congelante 🌫️❄️"
        in 51..55 -> "Garoa: leve, moderada ou intensa 🌦️"
        56, 57 -> "Garoa congelante: leve ou intensa 🌧️❄️"
        in 61..65 -> "Chuva: fraca, moderada ou forte 🌧️"
        66, 67 -> "Chuva congelante: leve ou forte 🌧️❄️"
        in 71..75 -> "Neve: fraca, moderada ou intensa 🌨️"
        77 -> "Grãos de neve ❄️"
        in 80..82 -> "Pancadas de chuva: fraca, moderada ou violenta 🌦️⛈️"
        85, 86 -> "Pancadas de neve: fraca ou intensa 🌨️"
        95 -> "Trovoada: fraca ou moderada ⛈️"
        96, 99 -> "Trovoada com granizo: leve ou forte ⛈️🌩️"
        else -> "Clima desconhecido ❓"
    }
}

@DrawableRes
fun getWeatherIcon(code: Int): Int{
    return when (code) {
        in 0..3  -> R.drawable.ic_sun
        in 45..48 -> R.drawable.cloud
        in 50..75 -> R.drawable.rain
        in 80..99 ->R.drawable.ic_thunderstorm
        else -> R.drawable.ic_sun
    }
}
