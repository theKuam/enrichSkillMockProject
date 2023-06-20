package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.runtime.Composable
import com.hainm.enrichskillmockproject.core.BaseScreen

@Composable
fun WelcomeScreen(onNavigate: () -> Unit) {
    BaseScreen(
        screenTitle = "Welcome",
        nextScreenTitle = "Home",
        onNavigate = onNavigate,
    )
}