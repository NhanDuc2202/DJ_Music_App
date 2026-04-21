package com.example.djmusicapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.djmusicapp.R

val NotoSans = FontFamily(
    Font(R.font.noto_sans_regular, FontWeight.Normal),
    Font(R.font.noto_sans_medium, FontWeight.Medium),
    Font(R.font.noto_sans_semibold, FontWeight.SemiBold),
    Font(R.font.noto_sans_bold, FontWeight.Bold)
)

val K2D = FontFamily(
    Font(R.font.k2d_regular, FontWeight.Normal),
    Font(R.font.k2d_extrabold, FontWeight.ExtraBold)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)