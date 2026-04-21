package com.example.djmusicapp.features.djmixer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DjDeckPanel(
    modifier: Modifier = Modifier,
    isLeft: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFF2A2A2A), CircleShape)
        )

        Box(
            modifier = Modifier
                .weight(0.55f)
                .background(Color(0xFF181818))
        )
    }
}