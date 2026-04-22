package com.example.djmusicapp.core.ui.librarypicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.djmusicapp.core.ui.components.CircleBackButton

@Composable
fun LibraryTopBar(
    title: String = "Library",
    menuIconRes: Int,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleBackButton(
            onClick = onBackClick,
            modifier = Modifier.padding(end = 12.dp)
        )

        Row(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.White
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.White
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.clickable() { onSearchClick() }
            )
            Icon(
                painter = painterResource(id = menuIconRes),
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.clickable() { onMenuClick() }
            )
        }
    }
}