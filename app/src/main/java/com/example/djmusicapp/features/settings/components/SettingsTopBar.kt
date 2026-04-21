package com.example.djmusicapp.features.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsTopBar(
    title: String,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0B0B14))
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(24.dp)
                .clickable { onBackClick() }
        )

        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}