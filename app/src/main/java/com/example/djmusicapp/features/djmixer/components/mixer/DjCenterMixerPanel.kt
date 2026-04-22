package com.example.djmusicapp.features.djmixer.components.mixer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun DjCenterMixerPanel(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF25272C),
                        Color(0xFF17191D),
                        Color(0xFF101114)
                    )
                )
            )
            .border(0.6.dp, Color(0xFF3A3D44))
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DjCenterTopKnobs()

        DjCenterMainMixer(
            modifier = Modifier.weight(1f)
        )

        DjCenterBottomButtons()

        DjCenterCrossfader()
    }
}

@Composable
private fun DjCenterTopKnobs() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DjLabeledKnob(label = "FILTER", accent = Color(0xFF00B7FF))
        DjLabeledKnob(label = "GAIN", accent = Color(0xFF00B7FF))
        DjLabeledKnob(label = "GAIN", accent = Color(0xFFFF0066))
        DjLabeledKnob(label = "FILTER", accent = Color(0xFFFF0066))
    }
}

@Composable
private fun DjCenterMainMixer(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DjEqColumn(
            modifier = Modifier.weight(1f),
            accent = Color(0xFF00B7FF),
            labels = listOf("TREBLE", "MID", "BASS")
        )

        DjCenterVolumeSection(
            modifier = Modifier.weight(1.15f)
        )

        DjEqColumn(
            modifier = Modifier.weight(1f),
            accent = Color(0xFFFF0066),
            labels = listOf("TREBLE", "MID", "BASS")
        )
    }
}

@Composable
private fun DjEqColumn(
    modifier: Modifier = Modifier,
    accent: Color,
    labels: List<String>
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        labels.forEach { label ->
            DjLabeledKnob(
                label = label,
                accent = accent,
                modifier = Modifier.weight(1f)
            )
        }

        DjMusicSquareButton(accent = accent)
    }
}

@Composable
private fun DjCenterVolumeSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DjLevelMeter(color = Color(0xFF00B7FF))
            DjBigCenterKnob()
            DjLevelMeter(color = Color(0xFFFF0066))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            DjVerticalFader(accent = Color(0xFF00B7FF))
            DjVerticalFader(accent = Color(0xFFFF0066))
        }
    }
}

@Composable
private fun DjBigCenterKnob() {
    DjLabeledKnob(
        label = "VOLUME",
        accent = Color(0xFF00B7FF),
        knobSize = 40,
        markerHeight = 13
    )
}

@Composable
private fun DjLevelMeter(
    color: Color
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(7) { index ->
            val meterColor = when {
                index < 3 -> Color(0xFF21C55D)
                index < 5 -> Color(0xFFFACC15)
                else -> Color(0xFFEF4444)
            }

            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(8.dp)
                    .background(meterColor, RoundedCornerShape(1.dp))
            )
        }
    }
}

@Composable
private fun DjVerticalFader(
    accent: Color
) {
    var sliderFraction by remember { mutableFloatStateOf(0.5f) }
    var trackHeightPx by remember { mutableFloatStateOf(0f) }

    val thumbHeight = 8.dp
    val thumbHeightPx = with(LocalDensity.current) { thumbHeight.toPx() }

    Box(
        modifier = Modifier
            .width(28.dp)
            .fillMaxHeight()
            .padding(vertical = 4.dp)
            .onSizeChanged { trackHeightPx = it.height.toFloat() }
            .pointerInput(trackHeightPx) {
                detectDragGestures(
                    onDragStart = { offset: Offset ->
                        if (trackHeightPx > 0f) {
                            sliderFraction =
                                ((offset.y - thumbHeightPx / 2f) / (trackHeightPx - thumbHeightPx))
                                    .coerceIn(0f, 1f)
                        }
                    },
                    onDrag = { change, _ ->
                        if (trackHeightPx > 0f) {
                            sliderFraction =
                                ((change.position.y - thumbHeightPx / 2f) / (trackHeightPx - thumbHeightPx))
                                    .coerceIn(0f, 1f)
                        }
                    }
                )
            }
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF0C0D10))
            .border(1.dp, Color(0xFF2E3138), RoundedCornerShape(6.dp))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
                .width(2.dp)
                .background(Color(0xFF2E3138))
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(thumbHeight)
                .offset() {
                    val y = ((trackHeightPx - thumbHeightPx) * sliderFraction).roundToInt()
                    IntOffset(0, y)
                }
                .background(accent)
        )
    }
}

@Composable
private fun DjMusicSquareButton(
    accent: Color
) {
    Box(
        modifier = Modifier
            .size(width = 38.dp, height = 24.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFF111318))
            .border(1.dp, accent, RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.MusicNote,
            contentDescription = null,
            tint = accent,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun DjCenterBottomButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DjCenterActionButton(
            text = "",
            icon = Icons.Default.GraphicEq,
            modifier = Modifier.weight(1f)
        )
        DjCenterActionButton(
            text = "REC",
            icon = Icons.Default.RadioButtonChecked,
            modifier = Modifier.weight(1f)
        )
        DjCenterActionButton(
            text = "",
            icon = Icons.Default.Settings,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun DjCenterActionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(28.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFF22242A))
            .border(1.dp, Color(0xFF3A3D45), RoundedCornerShape(5.dp))
            .padding(horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (text == "REC") Color.Red else Color.White,
                modifier = Modifier.size(14.dp)
            )

            if (text.isNotEmpty()) {
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun DjCenterCrossfader() {
    var sliderFraction by remember { mutableFloatStateOf(0.5f) }
    var trackWidthPx by remember { mutableFloatStateOf(0f) }

    val thumbWidth = 12.dp
    val thumbWidthPx = with(LocalDensity.current) { thumbWidth.toPx() }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "< A", color = Color.White, fontSize = 10.sp)
            Text(text = "B >", color = Color.White, fontSize = 10.sp)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp)
                .onSizeChanged { trackWidthPx = it.width.toFloat() }
                .pointerInput(trackWidthPx) {
                    detectDragGestures(
                        onDragStart = { offset: Offset ->
                            if (trackWidthPx > 0f) {
                                sliderFraction =
                                    ((offset.x - thumbWidthPx / 2f) / (trackWidthPx - thumbWidthPx))
                                        .coerceIn(0f, 1f)
                            }
                        },
                        onDrag = { change, _ ->
                            if (trackWidthPx > 0f) {
                                sliderFraction =
                                    ((change.position.x - thumbWidthPx / 2f) / (trackWidthPx - thumbWidthPx))
                                        .coerceIn(0f, 1f)
                            }
                        }
                    )
                }
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFF0E1014))
                .border(1.dp, Color(0xFF2E3138), RoundedCornerShape(4.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 28.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(8) {
                    Box(
                        modifier = Modifier
                            .width(2.dp)
                            .height(10.dp)
                            .background(Color(0xFF3A3D44))
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .height(4.dp)
                    .padding(horizontal = 20.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF00B7FF),
                                Color(0xFFFF0066)
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset {
                        val x = ((trackWidthPx - thumbWidthPx) * sliderFraction).roundToInt()
                        IntOffset(x, 0)
                    }
                    .size(width = thumbWidth, height = 24.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFF969BA5))
                    .border(1.dp, Color(0xFF2E3138), RoundedCornerShape(2.dp))
            )
        }
    }
}

@Composable
private fun DjLabeledKnob(
    label: String,
    accent: Color,
    modifier: Modifier = Modifier,
    knobSize: Int = 34,
    markerHeight: Int = 10
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(knobSize.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF8B8F97),
                            Color(0xFF555962),
                            Color(0xFF22242A)
                        )
                    )
                )
                .border(1.dp, Color(0xFFB0B5BE), CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 3.dp)
                    .width(2.dp)
                    .height(markerHeight.dp)
                    .background(accent, RoundedCornerShape(1.dp))
            )
        }

        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 8.sp
        )
    }
}