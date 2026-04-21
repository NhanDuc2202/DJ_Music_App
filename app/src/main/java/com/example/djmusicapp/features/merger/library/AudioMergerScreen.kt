package com.example.djmusicapp.features.merger.library

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.djmusicapp.core.ui.librarypicker.LibraryScreenContent
import androidx.compose.runtime.getValue


@Composable
fun AudioMergerScreen(
    navController: NavHostController,
    viewModel: SoundMergerLibraryViewModel = viewModel()
) {
    val files by viewModel.files.collectAsStateWithLifecycle()

    LibraryScreenContent (
        title = "Library",
        files = files,
        onBackClick = { navController.popBackStack() },
        onSearchClick = { },
        onMenuClick = { },
        onItemClick = viewModel::toggleSelection,
        onItemCheckedChange = viewModel::toggleSelection,
        onNextClick = {
            // next cho merger
        }
    )
}