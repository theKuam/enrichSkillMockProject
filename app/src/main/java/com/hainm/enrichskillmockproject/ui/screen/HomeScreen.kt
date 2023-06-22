package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hainm.enrichskillmockproject.common.util.Category
import com.hainm.enrichskillmockproject.common.util.SubCategory
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.ui.component.home.HomeMainView
import com.hainm.enrichskillmockproject.ui.component.home.HomeUserView
import com.hainm.enrichskillmockproject.ui.theme.AppBackground
import com.hainm.enrichskillmockproject.ui.theme.Spacing
import com.hainm.enrichskillmockproject.ui.viewmodel.HomeViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val articles = homeViewModel.articlesStateFlow.collectAsState()
    val isCarouselAutoPlayed = homeViewModel.isCarouselAutoPlayed.collectAsState()
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getRecommendedArticles(Category.GENERAL, SubCategory.ANIMAL)
    }
    BaseScreen {
        Box(
            modifier = Modifier
                .background(color = AppBackground)
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = Spacing.extraLarge,
                        end = Spacing.extraLarge,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(Spacing.extraSmall))
                HomeUserView()
                Spacer(modifier = Modifier.height(Spacing.extraSmall))
                HomeMainView(
                    isCarouselAutoPlayed,
                    { homeViewModel.startAutoPlayed() },
                    { homeViewModel.stopAutoPlayed() },
                )
            }
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                HomeNavigateBottomView()
            }
        }
    }
}

@Composable
fun HomeNavigateBottomView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Red)
    ) {
        Text(text = "navigate")
    }
}
