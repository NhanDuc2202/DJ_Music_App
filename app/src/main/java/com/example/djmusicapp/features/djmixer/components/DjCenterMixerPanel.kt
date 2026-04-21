package com.example.djmusicapp.features.djmixer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DjCenterMixerPanel(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF202020))
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(0.25f)
                .background(Color(0xFF2A2A2A))
        )

        Box(
            modifier = Modifier
                .weight(0.55f)
                .background(Color(0xFF181818))
        )

        Box(
            modifier = Modifier
                .weight(0.20f)
                .background(Color(0xFF101010))
        )
    }
}