package com.example.djmusicapp.features.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FolderOpen
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.NotificationsOff
import androidx.compose.material.icons.outlined.RadioButtonChecked
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SettingsOverscan
import com.example.djmusicapp.R
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.djmusicapp.features.settings.components.SettingsActionRowItem
import com.example.djmusicapp.features.settings.components.SettingsIcon
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
                    icon = SettingsIcon.Vector(Icons.Outlined.SettingsOverscan),
                    title = "Scan Library",
                    onClick = { }
                )
            }

            item {
                SettingsSectionTitle(title = "Record")
            }

            item {
                SettingsToggleItem (
                    icon = SettingsIcon.Vector(Icons.Outlined.RadioButtonChecked),
                    title = "View the Recording after it’s completed",
                    checked = uiState.viewRecordingAfterCompleted,
                    onCheckedChange = viewModel::onViewRecordingAfterCompletedChanged
                )
            }

            item {
                SettingsValueItem(
                    icon = SettingsIcon.Vector(Icons.Outlined.Videocam),
                    title = "Record Format",
                    value = "MP3",
                    onClick = { }
                )
            }

            item {
                SettingsValueItem(
                    icon = SettingsIcon.Vector(Icons.Outlined.Mic),
                    title = "Record Type",
                    value = "Internal Audio",
                    onClick = { }
                )
            }

            item {
                SettingsPathItem(
                    icon = SettingsIcon.Vector(Icons.Outlined.FolderOpen),
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
                    icon = SettingsIcon.Vector(Icons.Outlined.RadioButtonChecked),
                    title = "Use Notification Bar to Play Music",
                    checked = uiState.useNotificationBarToPlayMusic,
                    onCheckedChange = viewModel::onUseNotificationBarToPlayMusicChanged
                )
            }

            item {
                SettingsSectionTitle(title = "Others")
            }

            item {
                SettingsToggleItem (
                    icon = SettingsIcon.Vector(Icons.Outlined.Language),
                    title = "Use English Language",
                    checked = uiState.useEnglishLanguage,
                    onCheckedChange = viewModel::onUseEnglishLanguageChanged
                )
            }

            item {
                SettingsToggleItem (
                    icon = SettingsIcon.Vector(Icons.Outlined.NotificationsOff),
                    title = "Hide Update Reminder",
                    checked = uiState.hideUpdateReminder,
                    onCheckedChange = viewModel::onHideUpdateReminderChanged
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Vector(Icons.Outlined.Settings),
                    title = "Check for Update",
                    onClick = { }
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Drawable(R.drawable.feedback),
                    title = "Feedback",
                    onClick = { }
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Drawable(R.drawable.start),
                    title = "Rate Us",
                    onClick = { }
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Drawable(R.drawable.share),
                    title = "Share App",
                    onClick = { }
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Drawable(R.drawable.term_of_service),
                    title = "Terms of Service",
                    onClick = { }
                )
            }

            item {
                SettingsActionRowItem (
                    icon = SettingsIcon.Drawable(R.drawable.private_policy),
                    title = "Privacy Policy",
                    onClick = { }
                )
            }

        }
    }
}