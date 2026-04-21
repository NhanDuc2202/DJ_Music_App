package com.example.djmusicapp.features.settings.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

@Composable
fun SettingsSectionTitle(title: String) {
    Text(
        text = title,
        color = Color(0xFF9A9EB2),
        modifier = Modifier.padding(top = 10.dp, bottom = 2.dp)
    )
}