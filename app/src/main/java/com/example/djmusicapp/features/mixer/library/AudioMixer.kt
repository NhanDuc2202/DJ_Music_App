package com.example.djmusicapp.features.mixer.library

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.djmusicapp.core.ui.librarypicker.LibraryScreenContent
import androidx.compose.runtime.getValue

@Composable
fun AudioMixer(
    navController: NavHostController,
    viewModel: AudioMixerLibraryViewModel = viewModel()
) {
    val files by viewModel.files.collectAsStateWithLifecycle()

    LibraryScreenContent(
        title = "Library",
        files = files,
        onBackClick = { navController.popBackStack() },
        onSearchClick = { },
        onMenuClick = { },
        onItemClick = viewModel::toggleSelection,
        onItemCheckedChange = viewModel::toggleSelection,
        onNextClick = {
            // next cho mixer
        }
    )
}