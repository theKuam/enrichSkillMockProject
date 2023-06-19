package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hainm.enrichskillmockproject.common.navigation.ScreenDestination
import com.hainm.enrichskillmockproject.core.BaseScreen

@Composable
fun WelcomeScreen(navController: NavHostController) {
    BaseScreen(
        screenTitle = "Welcome",
        nextScreenTitle = "Home",
        onNavigate = { navController.navigate(ScreenDestination.HOME_SCREEN.name) },
    )
}