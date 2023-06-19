package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hainm.enrichskillmockproject.common.navigation.ScreenDestination
import com.hainm.enrichskillmockproject.core.BaseScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    BaseScreen(
        screenTitle = "Home",
        nextScreenTitle = "Article",
        onNavigate = { navController.navigate(ScreenDestination.ARTICLE_SCREEN.name) },
    )
}