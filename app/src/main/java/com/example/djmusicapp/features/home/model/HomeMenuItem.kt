package com.example.djmusicapp.features.home.model

import androidx.compose.ui.graphics.Color

data class HomeMenuItem(
    val title: String,
    val route: String,
    val iconRes: Int,
    val startColor: Color,
    val endColor: Color
)