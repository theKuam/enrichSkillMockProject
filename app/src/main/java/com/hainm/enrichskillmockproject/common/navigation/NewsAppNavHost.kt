package com.hainm.enrichskillmockproject.common.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hainm.enrichskillmockproject.common.viewmodel.SharedPreferenceViewModel
import com.hainm.enrichskillmockproject.ui.screen.ArticleScreen
import com.hainm.enrichskillmockproject.ui.screen.HomeScreen
import com.hainm.enrichskillmockproject.ui.screen.WelcomeScreen

@ExperimentalFoundationApi
@Composable
fun NewsAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val sharedPreferenceViewModel: SharedPreferenceViewModel = hiltViewModel()
    val isFirstLaunch = sharedPreferenceViewModel.isFirstLaunch.collectAsState()

    LaunchedEffect(key1 = Unit) {
        sharedPreferenceViewModel.getFirstLaunch()
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = firstLaunchScreen(
            sharedPreferenceViewModel,
            isFirstLaunch,
        ),
    ) {
        composable(route = ScreenDestination.WELCOME_SCREEN.name) {
            WelcomeScreen {
                navController.navigate(ScreenDestination.HOME_SCREEN.name) {
                    popUpTo(ScreenDestination.WELCOME_SCREEN.name) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = ScreenDestination.HOME_SCREEN.name) {
            HomeScreen {
                navController.navigate(ScreenDestination.ARTICLE_SCREEN.name)
            }
        }
        composable(route = ScreenDestination.ARTICLE_SCREEN.name) {
            ArticleScreen()
        }
    }
}

fun firstLaunchScreen(
    sharedPreferenceViewModel: SharedPreferenceViewModel,
    isFirstLaunch: State<Boolean?>,
): String {
    return if (isFirstLaunch.value == true) {
        sharedPreferenceViewModel.setFirstLaunch()
        ScreenDestination.WELCOME_SCREEN.name
    } else {
        ScreenDestination.HOME_SCREEN.name
    }
}


