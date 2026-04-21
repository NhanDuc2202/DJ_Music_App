package com.example.djmusicapp.features.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FolderOpen
import androidx.compose.material.icons.outlined.RadioButtonChecked
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.djmusicapp.features.settings.components.SettingsActionItem
import com.example.djmusicapp.features.settings.components.SettingsInfoItem
import com.example.djmusicapp.features.settings.components.SettingsNavigationItem
import com.example.djmusicapp.features.settings.components.SettingsPathItem
import com.example.djmusicapp.features.settings.components.SettingsSectionTitle
import com.example.djmusicapp.features.settings.components.SettingsToggleItem
import com.example.djmusicapp.features.settings.components.SettingsTopBar
import com.example.djmusicapp.features.settings.components.SettingsValueItem


@Composable
fun SettingsScreen(
    navController: NavHostController,
    viewModel: SettingsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var isEnabled by remember { mutableStateOf(false) }

    Scaffold (
        containerColor = Color(0xFF0B0B14),
        topBar = {
            SettingsTopBar(
                title = "Setting",
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0B0B14))
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = 24.dp
            )
        ) {
            item {
                SettingsSectionTitle(title = "General")
            }

            item {
                SettingsNavigationItem (
                    icon = Icons.Outlined.FolderOpen,
                    title = "Scan Library",
                    onClick = { }
                )
            }

            item {
                SettingsSectionTitle(title = "Record")
            }

            item {
                SettingsToggleItem (
                    icon = Icons.Outlined.RadioButtonChecked,
                    title = "View the Recording after it’s completed",
                    checked = isEnabled,
                    onCheckedChange = { isEnabled = it }
                )
            }

            item {
                SettingsValueItem(
                    icon = Icons.Outlined.Videocam,
                    title = "Record Format",
                    value = "MP3",
                    onClick = { }
                )
            }

            item {
                SettingsValueItem(
                    icon = Icons.Outlined.Videocam,
                    title = "Record Type",
                    value = "Internal Audio",
                    onClick = { }
                )
            }

            item {
                SettingsPathItem(
                    icon = Icons.Outlined.FolderOpen,
                    title = "Record Path",
                    path = "/storage/emulated/.../DJMusicGrid",
                    onClick = { }
                )
            }

            item {
                SettingsSectionTitle(title = "Audio")
            }

            item {
                SettingsToggleItem (
                    icon = Icons.Outlined.RadioButtonChecked,
                    title = "View the Recording after it’s completed",
                    checked = true,
                    onCheckedChange = { isEnabled = it }
                )
            }

            item {
                SettingsActionItem(
                    title = "Privacy Policy",
                    onClick = { }
                )
            }

            item {
                SettingsSectionTitle(title = "Others")
            }

            item {
                SettingsActionItem(
                    title = "Send Feedback",
                    onClick = { }
                )
            }
        }
    }
}