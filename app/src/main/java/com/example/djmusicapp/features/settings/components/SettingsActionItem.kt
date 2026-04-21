package com.example.djmusicapp.features.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsActionItem(
    title: String,
    onClick: () -> Unit
) {
    Text(
        text = title,
        color = Color.White,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF151826),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp)
    )
}