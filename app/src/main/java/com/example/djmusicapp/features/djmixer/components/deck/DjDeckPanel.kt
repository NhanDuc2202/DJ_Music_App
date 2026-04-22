package com.example.djmusicapp.features.djmixer.components.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import kotlin.math.roundToInt
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.scale

@Composable
fun DjDeckPanel(
    modifier: Modifier = Modifier,
    isLeft: Boolean
) {
    val accentColor = if (isLeft) {
        Color(0xFF00B7FF)
    } else {
        Color(0xFFFF0066)
    }


    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF202226),
                        Color(0xFF14161A),
                        Color(0xFF0E1013)
                    )
                )
            )
            .border(0.6.dp, Color(0xFF3A3D44))
    ) {
        DjDeckHeader(accentColor = accentColor)

        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            if (!isLeft) {
                DjPitchControl(
                    modifier = Modifier.width(56.dp),
                    accentColor = accentColor
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                DjDeckLampSection(
                    modifier = Modifier.fillMaxWidth(),
                    isLeft = isLeft
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (isLeft) {
                        DjLeftControls(
                            modifier = Modifier
                                .width(54.dp)
                                .fillMaxHeight(),
                            isLeft = true
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            DjTurnTable(
                                modifier = Modifier.weight(1f)
                            )

                            DjBottomControls(
                                isLeft = true
                            )
                        }
                    } else {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            DjTurnTable(
                                modifier = Modifier.weight(1f)
                            )

                            DjBottomControls(
                                isLeft = false
                            )
                        }

                        DjLeftControls(
                            modifier = Modifier
                                .width(54.dp)
                                .fillMaxHeight(),
                            isLeft = false
                        )
                    }
                }
            }

            if (isLeft) {
                DjPitchControl(
                    modifier = Modifier
                        .width(56.dp)
                        .fillMaxHeight(),
                    accentColor = accentColor
                )
            }
        }
    }
}


@Composable
private fun DjDeckHeader(accentColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Music",
            color = accentColor,
            fontSize = 12.sp
        )

        Text(
            text = "00:00",
            color = accentColor,
            fontSize = 12.sp
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color(0xFF3A3D44))
    )
}

@Composable
private fun DjLabeledSection(
    label: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 9.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        content()
    }
}

@Composable
private fun DjDeckLampSection(
    modifier: Modifier = Modifier,
    isLeft: Boolean
) {
    val items = listOf(
        "IN" to Color(0xFFFF9800),
        "OUT" to Color(0xFFFF9800),
        "RELOOP/EXIT" to Color(0xFF39D353)
    )

    val arrangedItems = if (isLeft) items else items.reversed()

    Row(
        modifier = modifier,
        horizontalArrangement = if (isLeft) Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        arrangedItems.forEachIndexed { index, (label, lampColor) ->
            DjLampItem(
                label = label,
                lampColor = lampColor
            )

            if (index != arrangedItems.lastIndex) {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}

@Composable
private fun DjLampItem(
    label: String,
    lampColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 7.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        DjLamp(lampColor)
    }
}

@Composable
private fun DjLamp(color: Color) {
    Box(
        modifier = Modifier
            .size(22.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.9f),
                        color,
                        Color.Black
                    )
                ),
                shape = CircleShape
            )
            .border(1.dp, Color(0xFF1A1A1A), CircleShape)
    )
}


@Composable
private fun DjTurnTable(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF4B4E56),
                            Color(0xFF23252B),
                            Color(0xFF101115)
                        )
                    )
                )
                .border(2.dp, Color(0xFF9AA0A8), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.82f)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF2D3037),
                                Color(0xFF17191F),
                                Color(0xFF0B0C10)
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .size(78.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF4A4D56),
                                Color(0xFF2C2E35),
                                Color(0xFF18191D)
                            )
                        )
                    )
                    .border(1.dp, Color(0xFF8E939B), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "0.0",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "BPM",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Composable
private fun DjLeftControls(
    modifier: Modifier = Modifier,
    isLeft: Boolean
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DjLabeledSection(label = "MODE") {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                DjMiniRoundButton(icon = Icons.Default.Refresh)
                DjMiniRoundButton(icon = Icons.Default.Sync)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        DjLabeledSection(label = "TRACK") {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                if (isLeft) {
                    DjMiniRoundButton(icon = Icons.Default.SkipNext, rotate180 = true)
                    DjMiniRoundButton(icon = Icons.Default.SkipNext)
                } else {
                    DjMiniRoundButton(icon = Icons.Default.SkipNext)
                    DjMiniRoundButton(icon = Icons.Default.SkipNext, rotate180 = true)
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        DjCueButton()

        Spacer(modifier = Modifier.height(10.dp))

        DjPlayButton()
    }
}

//slider
@Composable
private fun DjPitchControl(
    modifier: Modifier = Modifier,
    accentColor: Color
) {
    var sliderFraction by remember { mutableFloatStateOf(0.5f) }
    var trackHeightPx by remember { mutableFloatStateOf(0f) }
    val thumbHeight = 8.dp
    val thumbHeightPx = with(LocalDensity.current) { thumbHeight.toPx() }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PITCH BEND",
            color = Color.LightGray,
            fontSize = 9.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            DjCircleSignButton("-")
            DjCircleSignButton("+")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            DjTagButton("SYNC")
            DjTagButton("PITCH")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .width(28.dp)
                .height(110.dp)
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
                .background(Color(0xFF090A0D), RoundedCornerShape(6.dp))
                .border(1.dp, Color(0xFF2E3138), RoundedCornerShape(6.dp))
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .height(thumbHeight)
                    .offset {
                        val y = ((trackHeightPx - thumbHeightPx) * sliderFraction).roundToInt()
                        IntOffset(0, y)
                    }
                    .background(accentColor)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        DjSmallRectButton(
            text = "RESET",
            modifier = Modifier.width(44.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        DjSmallRectButton(
            text = "FX",
            modifier = Modifier.width(44.dp)
        )
    }
}


@Composable
private fun DjBottomControls(
    isLeft: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = if (isLeft) Alignment.CenterStart else Alignment.CenterEnd
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            if (isLeft) {
                DjLeftPadBlock()
            } else {
                DjRightPadBlock()
            }
        }
    }
}

@Composable
private fun DjLeftPadBlock(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "HOT CUES",
                    borderColor = Color(0xFF00F0FF),
                    fillColor = Color(0xFF11D9C5),
                    selected = true,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "1",
            bottomPad = "5",
            topPadColor = Color(0xFF7C00FF),
            bottomPadColor = Color(0xFFFFC400),
            modifier = Modifier.weight(1f)
        )

        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "LOOP",
                    borderColor = Color(0xFFFF9800),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "2",
            bottomPad = "6",
            topPadColor = Color(0xFFFF0066),
            bottomPadColor = Color(0xFF004DFF),
            modifier = Modifier.weight(1f)
        )

        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "SAMPLER1",
                    borderColor = Color(0xFF46B8FF),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "3",
            bottomPad = "7",
            topPadColor = Color(0xFF00D9FF),
            bottomPadColor = Color(0xFFFF0066),
            modifier = Modifier.weight(1f)
        )

        DjBottomSamplerColumn(
            topPad = "4",
            bottomPad = "8",
            topPadColor = Color(0xFF7CFC00),
            bottomPadColor = Color(0xFFB000FF),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun DjRightPadBlock(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "HOT CUES",
                    borderColor = Color(0xFF00F0FF),
                    fillColor = Color(0xFF11D9C5),
                    selected = true,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "1/8",
            bottomPad = "2",
            topPadColor = Color(0xFF7C00FF),
            bottomPadColor = Color(0xFFFFC400),
            modifier = Modifier.weight(1f)
        )

        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "LOOP",
                    borderColor = Color(0xFFFF9800),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "1/4",
            bottomPad = "4",
            topPadColor = Color(0xFFFF9800),
            bottomPadColor = Color(0xFF004DFF),
            modifier = Modifier.weight(1f)
        )

        DjBottomPadColumn(
            topContent = {
                DjModeTab(
                    text = "SAMPLER1",
                    borderColor = Color(0xFF46B8FF),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            topPad = "1/2",
            bottomPad = "8",
            topPadColor = Color(0xFF46B8FF),
            bottomPadColor = Color(0xFFFF0066),
            modifier = Modifier.weight(1f)
        )

        DjBottomSamplerColumn(
            topPad = "1",
            bottomPad = "16",
            topPadColor = Color(0xFF7CFC00),
            bottomPadColor = Color(0xFFB000FF),
            modifier = Modifier.weight(1f)
        )
    }
}


//@Composable
//private fun DjActionBlock(
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier.width(52.dp),
//        verticalArrangement = Arrangement.spacedBy(6.dp)
//    ) {
//        DjSmallRectButton("RESET")
//        DjSmallRectButton("FX")
//    }
//}

@Composable
private fun DjBottomPadColumn(
    topContent: @Composable () -> Unit,
    topPad: String,
    bottomPad: String,
    topPadColor: Color,
    bottomPadColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp),
            contentAlignment = Alignment.Center
        ) {
            topContent()
        }

        DjPad(
            text = topPad,
            color = topPadColor,
            modifier = Modifier.fillMaxWidth()
        )

        DjPad(
            text = bottomPad,
            color = bottomPadColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun DjBottomSamplerColumn(
    modifier: Modifier = Modifier,
    topPad: String,
    bottomPad: String,
    topPadColor: Color,
    bottomPadColor: Color
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DjTimeBox(
            text = "2.5s",
            modifier = Modifier.fillMaxWidth())

        DjModeTab(
            text = "SAMPLER2",
            borderColor = Color(0xFFFF00C8),
            modifier = Modifier.fillMaxWidth()
        )

        DjPad(
            text = topPad,
            color = topPadColor,
            modifier = Modifier.fillMaxWidth()
        )

        DjPad(
            text = bottomPad,
            color = bottomPadColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun DjModeTab(
    text: String,
    borderColor: Color,
    modifier: Modifier = Modifier,
    fillColor: Color = Color.Transparent,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        label = "mode_tab_scale"
    )

    val backgroundColor = when {
        isPressed -> borderColor.copy(alpha = 0.28f)
        selected -> fillColor
        else -> Color(0xFF101114)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(28.dp)
            .scale(scale.value)
            .clip(RoundedCornerShape(2.dp))
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(2.dp)
            )
            .padding(horizontal = 2.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 7.sp,
            fontWeight = if (isPressed) FontWeight.Bold else FontWeight.Medium,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Clip,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun DjTimeBox(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(22.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(Color(0xFF101114))
            .border(
                width = 1.dp,
                color = Color(0xFF46B8FF),
                shape = RoundedCornerShape(2.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 8.sp,
            maxLines = 1
        )
    }
}
@Composable
private fun DjMiniRoundButton(
    icon: ImageVector,
    rotate180: Boolean = false,
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.94f else 1f,
        label = "mini_round_scale"
    )

    Box(
        modifier = Modifier
            .size(28.dp)
            .scale(scale.value)
            .background(
                brush = Brush.radialGradient(
                    colors = if (isPressed) {
                        listOf(
                            Color(0xFF7A7E88),
                            Color(0xFF3A3F49),
                            Color.Black
                        )
                    } else {
                        listOf(
                            Color(0xFF50535A),
                            Color(0xFF202228),
                            Color.Black
                        )
                    }
                ),
                shape = CircleShape
            )
            .border(
                1.2.dp,
                if (isPressed) Color(0xFFA98CFF) else Color(0xFF7E55FF),
                CircleShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun DjCueButton(
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        label = "cue_button_scale"
    )

    Box(
        modifier = Modifier
            .size(38.dp)
            .scale(scale.value)
            .background(
                if (isPressed) Color(0xFF4A3320) else Color(0xFF2A2B2F),
                CircleShape
            )
            .border(
                2.dp,
                if (isPressed) Color(0xFFFFC266) else Color(0xFFFF9800),
                CircleShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "CUE",
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = if (isPressed) FontWeight.ExtraBold else FontWeight.Bold
        )
    }
}

@Composable
private fun DjPlayButton(
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        label = "play_button_scale"
    )

    Box(
        modifier = Modifier
            .size(38.dp)
            .scale(scale.value)
            .background(
                if (isPressed) Color(0xFF243A20) else Color(0xFF2A2B2F),
                CircleShape
            )
            .border(
                2.dp,
                if (isPressed) Color(0xFFA8FF8A) else Color(0xFF7CFC00),
                CircleShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
private fun DjCircleSignButton(
    text: String,
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.94f else 1f,
        label = "circle_sign_scale"
    )

    Box(
        modifier = Modifier
            .size(28.dp)
            .scale(scale.value)
            .background(
                brush = Brush.radialGradient(
                    colors = if (isPressed) {
                        listOf(
                            Color(0xFF6C717A),
                            Color(0xFF343842),
                            Color.Black
                        )
                    } else {
                        listOf(
                            Color(0xFF4E5158),
                            Color(0xFF22242A),
                            Color.Black
                        )
                    }
                ),
                shape = CircleShape
            )
            .border(
                1.dp,
                if (isPressed) Color.White else Color(0xFF44474F),
                CircleShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = if (isPressed) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun DjTagButton(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF191B20))
            .border(1.dp, Color(0xFF41444B), RoundedCornerShape(10.dp))
            .padding(horizontal = 6.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.White, fontSize = 8.sp)
    }
}

//@Composable
//private fun DjTab(text: String, color: Color) {
//    Box(
//        modifier = Modifier
//            .clip(RoundedCornerShape(2.dp))
//            .background(Color(0xFF101114))
//            .border(1.dp, color, RoundedCornerShape(2.dp))
//            .padding(horizontal = 6.dp, vertical = 3.dp)
//    ) {
//        Text(text, color = Color.White, fontSize = 8.sp)
//    }
//}

//@Composable
//private fun DjPadGrid() {
//    Column(
//        verticalArrangement = Arrangement.spacedBy(6.dp)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(6.dp)
//        ) {
//            DjPad("1", Color(0xFF7C00FF), modifier = Modifier.weight(1f))
//            DjPad("2", Color(0xFFFF0066), modifier = Modifier.weight(1f))
//            DjPad("3", Color(0xFF00D9FF), modifier = Modifier.weight(1f))
//            DjPad("4", Color(0xFF7CFC00), modifier = Modifier.weight(1f))
//        }
//
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(6.dp)
//        ) {
//            DjPad("5", Color(0xFFFFC400), modifier = Modifier.weight(1f))
//            DjPad("6", Color(0xFF004DFF), modifier = Modifier.weight(1f))
//            DjPad("7", Color(0xFFFF0066), modifier = Modifier.weight(1f))
//            DjPad("8", Color(0xFFB000FF), modifier = Modifier.weight(1f))
//        }
//    }
//}

@Composable
private fun DjPad(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.94f else 1f,
        label = "dj_pad_scale"
    )

    val backgroundColor = if (isPressed) {
        color.copy(alpha = 0.35f)
    } else {
        Color(0xFF101114)
    }

    val borderColor = if (isPressed) {
        color.copy(alpha = 1f)
    } else {
        color.copy(alpha = 0.85f)
    }

    Box(
        modifier = modifier
            .height(22.dp)
            .scale(scale.value)
            .clip(RoundedCornerShape(2.dp))
            .background(backgroundColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(2.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isPressed) Color.White else Color.White,
            fontSize = 11.sp,
            fontWeight = if (isPressed) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun DjSmallRectButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val (interactionSource, isPressed) = rememberPressedState()
    val scale = animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        label = "small_rect_scale"
    )

    Box(
        modifier = modifier
            .height(28.dp)
            .scale(scale.value)
            .clip(RoundedCornerShape(4.dp))
            .background(
                if (isPressed) Color(0xFF3A4458) else Color(0xFF22242A)
            )
            .border(
                1.dp,
                if (isPressed) Color(0xFF89C8FF) else Color(0xFF3A3D45),
                RoundedCornerShape(4.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color(0xFF89C8FF),
            fontSize = 9.sp,
            fontWeight = if (isPressed) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun rememberPressedState(): Pair<MutableInteractionSource, Boolean> {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    return interactionSource to isPressed
}