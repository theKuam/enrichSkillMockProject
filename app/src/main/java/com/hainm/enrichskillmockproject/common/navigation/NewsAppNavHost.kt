package com.hainm.enrichskillmockproject.common.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hainm.enrichskillmockproject.common.util.EMPTY_STRING
import com.hainm.enrichskillmockproject.common.viewmodel.SharedPreferenceViewModel
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.screen.ArticleScreen
import com.hainm.enrichskillmockproject.ui.screen.HomeScreen
import com.hainm.enrichskillmockproject.ui.screen.WelcomeScreen
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.Base64

private const val ARTICLE_PARCEL_KEY = "article"

@ExperimentalFoundationApi
@Composable
fun NewsAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val sharedPreferenceViewModel: SharedPreferenceViewModel = hiltViewModel()
    val isFirstLaunch = sharedPreferenceViewModel.isFirstLaunch.collectAsState()
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

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
            HomeScreen { article ->
                val jsonAdapter = moshi.adapter(Article::class.java)
                val articleJsonString = jsonAdapter.toJson(article)
                navController.navigate(
                    "${ScreenDestination.ARTICLE_SCREEN.name}/{article}"
                        .replace(
                            oldValue = "{article}",
                            newValue = Base64.getUrlEncoder()
                                .encodeToString(articleJsonString.toByteArray()),
                        )
                )
            }
        }
        composable(
            route = "${ScreenDestination.ARTICLE_SCREEN.name}/{article}",
            arguments = listOf(
                navArgument(ARTICLE_PARCEL_KEY) {
                    type = NavType.StringType
                    defaultValue = EMPTY_STRING
                }
            )
        ) { backStackEntry ->
            val articleJsonString = backStackEntry.arguments?.getString(ARTICLE_PARCEL_KEY)
            articleJsonString?.let { json ->
                val jsonAdapter = moshi.adapter(Article::class.java)
                val article = jsonAdapter.fromJson(String(Base64.getUrlDecoder().decode(json)))
                article?.let {
                    ArticleScreen(it) {
                        navController.popBackStack()
                    }
                }
            }
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


