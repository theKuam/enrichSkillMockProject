package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.common.util.Category
import com.hainm.enrichskillmockproject.common.util.SubCategory
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.component.home.HomeNavigateBottomView
import com.hainm.enrichskillmockproject.ui.component.home.HomeUserView
import com.hainm.enrichskillmockproject.ui.component.home.HomeViewPager
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundLower
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundMiddle
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundUpper
import com.hainm.enrichskillmockproject.ui.theme.Spacing
import com.hainm.enrichskillmockproject.ui.viewmodel.HomeViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(onNavigate: (Article) -> Unit) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val articles = homeViewModel.articlesStateFlow.collectAsState()
    val isCarouselAutoPlayed = homeViewModel.isCarouselAutoPlayed.collectAsState()
    var category by remember { mutableStateOf(Category.GENERAL) }
    var subCategory by remember { mutableStateOf(SubCategory.ANIMAL) }
    var tabIndex by remember { mutableIntStateOf(0) }
    var isTabSelected by remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        CAROUSEL_PAGE_COUNT
    }
    LaunchedEffect(key1 = category, key2 = subCategory) {
        homeViewModel.getRecommendedArticles(category, subCategory)
    }
    BaseScreen {
        val density = LocalDensity.current
        val configuration = LocalConfiguration.current
        with(density) {
            val contentRatio = 1f - 60.dp.toPx() / configuration.screenHeightDp.dp.roundToPx()
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            0.0f to AppBackgroundUpper,
                            0.5f to AppBackgroundUpper,
                            0.75f to AppBackgroundMiddle,
                            1f to AppBackgroundLower,
                        )
                    )
                    .statusBarsPadding()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(fraction = contentRatio)
                        .padding(
                            start = Spacing.extraLarge,
                            end = Spacing.extraLarge,
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(Spacing.extraSmall))
                    HomeUserView()
                    Spacer(modifier = Modifier.height(Spacing.extraSmall))
                    HomeViewPager(
                        pagerState,
                        isCarouselAutoPlayed,
                        { homeViewModel.startAutoPlayed() },
                        { homeViewModel.stopAutoPlayed() },
                        articles,
                        { category = it },
                        { subCategory = it },
                        tabIndex,
                        isTabSelected,
                        onNavigate,
                    )
                }
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    HomeNavigateBottomView(pagerState.currentPage) {
                        tabIndex = it
                        isTabSelected = !isTabSelected
                    }
                }
            }
        }
    }
}
