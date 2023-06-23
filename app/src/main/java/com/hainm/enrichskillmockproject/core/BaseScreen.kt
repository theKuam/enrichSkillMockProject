package com.hainm.enrichskillmockproject.core

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BaseScreen(
    content: @Composable () -> Unit,
) {
    HideSystemUI()
    Surface(modifier = Modifier.fillMaxSize()) {
        content()
    }
}

@Composable
private fun HideSystemUI() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
        )
        systemUiController.isNavigationBarVisible = false

        onDispose {}
    }
}
