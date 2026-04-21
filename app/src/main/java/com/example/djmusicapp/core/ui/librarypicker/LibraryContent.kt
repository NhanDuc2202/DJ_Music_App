package com.example.djmusicapp.core.ui.librarypicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.djmusicapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.djmusicapp.core.model.AudioFileItem

@Composable
fun LibraryScreenContent(
    title: String = "Library",
    files: List<AudioFileItem>,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onItemClick: (String) -> Unit,
    onItemCheckedChange: (String) -> Unit,
    onNextClick: () -> Unit
) {
    val selectedCount = files.count { it.isSelected }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF05030E))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                LibraryTopBar(
                    title = title,
                    menuIconRes = R.drawable.iwwa_option,
                    onBackClick = onBackClick,
                    onSearchClick = onSearchClick,
                    onMenuClick = onMenuClick
                )
            }

            items(files, key = { it.id }) { item ->
                AudioFileRow(
                    item = item,
                    onClick = { onItemClick(item.id) },
                    onCheckedChange = { onItemCheckedChange(item.id) }
                )
            }
        }

        if (selectedCount > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                SelectionBottomBar(
                    selectedCount = selectedCount,
                    onNextClick = onNextClick
                )
            }
        }
    }
}