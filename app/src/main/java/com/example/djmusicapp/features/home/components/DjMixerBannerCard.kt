package com.example.djmusicapp.features.home.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.djmusicapp.R
import com.example.djmusicapp.core.navigation.Routes

@Composable
fun DjMixerBannerCard(
    navController: NavController
) {
    val infiniteTransition = rememberInfiniteTransition(label = "border_anim")

    val borderColor1 = infiniteTransition.animateColor(
        initialValue = Color(0xFF22D3FF),
        targetValue = Color(0xFF7C4DFF),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "borderColor1"
    )

    val borderColor2 = infiniteTransition.animateColor(
        initialValue = Color(0xFF7C4DFF),
        targetValue = Color(0xFF22D3FF),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "borderColor2"
    )

    val glowAlpha = infiniteTransition.animateFloat(
        initialValue = 0.55f,
        targetValue = 0.95f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    val outerShape = RoundedCornerShape(18.dp)
    val innerShape = RoundedCornerShape(16.4.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .height(168.dp)
            .clickable {
                if (navController.currentDestination?.route != Routes.DjMixer.route) {
                    navController.navigate(Routes.DjMixer.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(128.dp)
                .border(
                    border = BorderStroke(
                        width = 1.4.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                borderColor1.value.copy(alpha = glowAlpha.value),
                                Color(0xFF29C3FF),
                                borderColor2.value.copy(alpha = glowAlpha.value)
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
                    .background(Color.Black.copy(alpha = 0.14f))
                    .border(
                        width = 0.4.dp,
                        color = Color.White.copy(alpha = 0.05f),
                        shape = innerShape
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 14.dp, top = 24.dp, bottom = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1.2f)
                            .padding(top = 8.dp, end = 6.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "DJ Mixer",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = "Mix your music with advanced tools, effects, and sound equalizer.",
                            color = Color(0xFFB8D7E8),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.78f)
                            .fillMaxHeight()
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .matchParentSize()
                .drawWithContent {
                    clipRect (
                        left = -1000f,
                        top = -1000f,
                        right = size.width + 1000f,
                        bottom = size.height
                    ) {
                        this@drawWithContent.drawContent()
                    }
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dj_mixer),
                contentDescription = "DJ Mixer astronaut",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .requiredHeight(230.dp)
                    .offset(x = 16.dp, y = 25.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}