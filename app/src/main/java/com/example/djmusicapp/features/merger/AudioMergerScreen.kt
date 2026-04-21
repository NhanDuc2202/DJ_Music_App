package com.example.djmusicapp.features.merger

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun AudioMergerScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF05010F)),
        contentAlignment = Alignment.Center
    ) {
        Text("Audio Merger Screen", color = Color.White)
    }
}