package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.ui.component.common.hometab.HomeTabRow
import com.hainm.enrichskillmockproject.ui.component.common.hometab.HomeTabTitle
import com.hainm.enrichskillmockproject.ui.theme.HomeCategoryBackground
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeMainView(
    isCarouselAutoPlayed: State<Boolean>,
    onPlayButtonClicked: () -> Unit,
    onPauseButtonClicked: () -> Unit,
) {
    val pagerState = rememberPagerState()
    Column {
        Spacer(modifier = Modifier.height(Spacing.large))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 2.2f)
                .clip(shape = RoundedCornerShape(size = 24.dp))
        ) {
            HomeCarousel(
                pagerState,
                isCarouselAutoPlayed,
                onPlayButtonClicked,
                onPauseButtonClicked,
            )
        }
        Spacer(modifier = Modifier.height(Spacing.large))
        HomeArticlePager(
            pagerState,
            onPauseButtonClicked,
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeArticlePager(
    pagerState: PagerState,
    onPauseButtonClicked: () -> Unit,
) {

    HomeArticleTabs(
        pagerState,
        onPauseButtonClicked,
    )
//    HomeArticleList()
}

@ExperimentalFoundationApi
@Composable
fun HomeArticleTabs(
    pagerState: PagerState,
    onPauseButtonClicked: () -> Unit,
) {
    val categoryList = stringArrayResource(id = R.array.article_categories)
    val pageCount = categoryList.size
    val currentIndex = pagerState.currentPage % pageCount
    var viewWidth by remember { mutableStateOf(0f) }
    var viewHeight by remember { mutableStateOf(0f) }
    var selectedIndex by remember { mutableStateOf(currentIndex) }
    LaunchedEffect(key1 = selectedIndex) {
        with(pagerState) {
            val target = selectedIndex
            animateScrollToPage(
                page = target,
                animationSpec = tween(
                    durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
                    easing = FastOutSlowInEasing,
                )
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(7.5f)
            .background(
                color = HomeCategoryBackground,
                shape = RoundedCornerShape(size = Spacing.small),
            )
            .onGloballyPositioned { coordinates ->
                viewWidth = coordinates.size.width.toFloat()
                viewHeight = coordinates.size.height.toFloat()
            }
    ) {
        HomeTabRow(
            width = viewWidth,
            height = viewHeight,
            selectedTabPosition = currentIndex,
        ) {
            stringArrayResource(id = R.array.article_categories).forEachIndexed { index, title ->
                HomeTabTitle(title, position = index) {
                    selectedIndex = index
                    onPauseButtonClicked()
                }
            }
        }
    }
}
