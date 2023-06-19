package com.hainm.enrichskillmockproject.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hainm.enrichskillmockproject.ui.screen.ArticleScreen
import com.hainm.enrichskillmockproject.ui.screen.HomeScreen
import com.hainm.enrichskillmockproject.ui.screen.WelcomeScreen

@Composable
fun NewsAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ScreenDestination.WELCOME_SCREEN.name,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = ScreenDestination.WELCOME_SCREEN.name) {
            WelcomeScreen(navController)
        }
        composable(route = ScreenDestination.HOME_SCREEN.name) {
            HomeScreen(navController)
        }
        composable(route = ScreenDestination.ARTICLE_SCREEN.name) {
            ArticleScreen()
        }
    }
}