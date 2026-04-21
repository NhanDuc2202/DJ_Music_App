package com.example.djmusicapp.features.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.djmusicapp.features.home.model.HomeMenuItem

@Composable
fun AnimatedMenuCard(
    item: HomeMenuItem,
    onClick: () -> Unit
) {
    val outerShape = RoundedCornerShape(18.dp)
    val innerShape = RoundedCornerShape(16.5.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(outerShape)
            .clickable { onClick() }
            .border(
                border = BorderStroke(
                    width = 1.4.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            item.startColor, item.endColor
                        )
                    )
                ),
                shape = outerShape
            )
            .padding(1.4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(innerShape)
                .background(Color.Black.copy(alpha = 0.6f))
                .border(
                    width = 0.4.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    shape = innerShape
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = item.iconRes),
                    contentDescription = item.title,
                    modifier = Modifier
                        .height(72.dp)
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = item.title,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}