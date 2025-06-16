package com.example.weather.ui.screen.section

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weather.ui.screen.TodayDateText

@Composable
fun TopAppBarSection() {
    Column {
        Text("São José do Rio Pardo", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        TodayDateText()
    }
}
