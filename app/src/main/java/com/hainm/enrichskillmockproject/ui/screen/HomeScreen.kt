package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.common.failed
import com.hainm.enrichskillmockproject.common.loading
import com.hainm.enrichskillmockproject.common.succeeded
import com.hainm.enrichskillmockproject.common.util.Category
import com.hainm.enrichskillmockproject.common.util.SubCategory
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val articles = homeViewModel.articlesStateFlow.collectAsState()
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getRecommendedArticles(Category.GENERAL, SubCategory.ANIMAL)
    }
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            articles.value.apply {
                when {
                    succeeded -> Text(text = articles.value.data.toString())
                    failed -> Text(text = (articles.value as Outcome.Error).throwable.message.toString())
                    loading -> Text(text = "Loading")
                }
            }
        }
    }
}