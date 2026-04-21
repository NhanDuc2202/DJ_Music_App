package com.example.djmusicapp.features.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsBaseItem(
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 58.dp)
        .background(
            color = Color(0xFF161823),
            shape = RoundedCornerShape(18.dp)
        )
        .then(
            if (onClick != null) Modifier.clickable { onClick() }
            else Modifier
        )
        .padding(horizontal = 14.dp, vertical = 12.dp)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}