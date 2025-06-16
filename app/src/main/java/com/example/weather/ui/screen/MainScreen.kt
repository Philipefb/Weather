package com.example.weather.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ViewModel.WeatherViewModel
import com.example.weather.data.network.WeatherResponse
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather.R
import com.example.weather.ViewModel.WeatherUiModel
import com.example.weather.ViewModel.hourlyUiWeather
import com.example.weather.ui.screen.section.TopAppBarSection
import com.example.weather.ui.screen.section.CurrentTemperatureSection
import java.util.Locale


@Composable
fun MainScreen(weatherViewModel: WeatherViewModel) {

    weatherViewModel.let { viewModel ->
        val weatherData by viewModel.uiState.collectAsState()

        LaunchedEffect(weatherData) {
            println("🟢 Dados atualizados: $weatherData")
        }

        LoadingScreen(weatherData)
    }
}

@Composable
fun LoadingScreen(weatherData: WeatherUiModel?) {
    if (weatherData == null) {
        // Exibir um loading ou fallback
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101824))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )  {
            Image(painter = painterResource(id = R.drawable.cycle), contentDescription = null,   modifier = Modifier.size(96.dp))
        }
        return
    }
    WeatherScreen(weatherData)
}

@Composable
fun WeatherScreen(weatherData: WeatherUiModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101824))
            .padding(16.dp)
    ) {
        TopAppBarSection()
        Spacer(modifier = Modifier.height(16.dp))
        CurrentTemperatureSection(weatherData.currentWeather)
        Spacer(modifier = Modifier.height(40.dp))
        WeatherStatsSection()
        Spacer(modifier = Modifier.height(16.dp))
        HourlyForecastSection(weatherData.hourlyWeather)
        Spacer(modifier = Modifier.height(16.dp))
        WeeklyForecastSection()
    }
}

@Composable
fun WeatherStatsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherStatItem("10 m/s", "Wind")
        WeatherStatItem("96%", "Humidity")
        WeatherStatItem("100%", "Rain")
    }
}

@Composable
fun WeatherStatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color.LightGray, fontSize = 14.sp)
    }
}

@Composable
fun HourlyForecastSection(hourly: hourlyUiWeather) {
    LazyRow {
        items(6) { index ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFF1E2B47)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("${10 + index} am", color = Color.White)
                Image(painter = painterResource(id = R.drawable.ic_bolt), contentDescription = null)
                Text("${16 + index}°", color = Color.White)
            }
        }
    }
}

@Composable
fun WeeklyForecastSection() {
    LazyColumn {
        items(7) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")[index],
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_bolt),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("${13 + index}° / ${22 + index}°", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun SimpleComposablePreview() {
    LoadingScreen(null)
}

