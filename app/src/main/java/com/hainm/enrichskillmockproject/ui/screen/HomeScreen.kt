package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.runtime.Composable
import com.hainm.enrichskillmockproject.core.BaseScreen

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    BaseScreen(
        screenTitle = "Home",
        nextScreenTitle = "Article",
        onNavigate = onNavigate,
    )
}