package com.hainm.enrichskillmockproject.common.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hainm.enrichskillmockproject.common.viewmodel.NewsAppViewModel
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.screen.ArticleScreen
import com.hainm.enrichskillmockproject.ui.screen.HomeScreen
import com.hainm.enrichskillmockproject.ui.screen.LoadingScreen
import com.hainm.enrichskillmockproject.ui.screen.WelcomeScreen

@ExperimentalMotionApi
@ExperimentalFoundationApi
@Composable
fun NewsAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val newsAppViewModel: NewsAppViewModel = hiltViewModel()
    val isFirstLaunch = newsAppViewModel.isFirstLaunch.collectAsState()
    var articleModel by remember { mutableStateOf(ArticleModel()) }

    LaunchedEffect(key1 = Unit) {
        newsAppViewModel.getFirstLaunch()
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = firstLaunchScreen(
            newsAppViewModel,
            isFirstLaunch,
        ),
    ) {
        composable(route = ScreenDestination.LOADING_SCREEN.name) {
            LoadingScreen()
        }

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
            HomeScreen { article ->
                articleModel = article
                navController.navigate(ScreenDestination.ARTICLE_SCREEN.name)
            }
        }

        composable(
            route = ScreenDestination.ARTICLE_SCREEN.name
        ) {
            ArticleScreen(articleModel) {
                navController.popBackStack()
            }
        }
    }
}

fun firstLaunchScreen(
    newsAppViewModel: NewsAppViewModel,
    isFirstLaunch: State<Boolean?>,
): String {
    return when (isFirstLaunch.value) {
        true -> {
            newsAppViewModel.setFirstLaunch()
            ScreenDestination.WELCOME_SCREEN.name
        }

        false -> {
            ScreenDestination.HOME_SCREEN.name
        }

        else -> {
            ScreenDestination.LOADING_SCREEN.name
        }
    }
}


