package com.hainm.enrichskillmockproject.ui.component.home.article

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringArrayResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.Category
import com.hainm.enrichskillmockproject.common.util.SubCategory
import com.hainm.enrichskillmockproject.common.util.TAB_INDICATOR_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.ui.component.common.hometab.HomeTabRow
import com.hainm.enrichskillmockproject.ui.component.common.hometab.HomeTabTitle
import com.hainm.enrichskillmockproject.ui.theme.HomeCategoryBackground
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeArticleTabs(
    pagerState: PagerState,
    onPauseButtonClicked: () -> Unit,
    onCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
) {
    val categoryList = stringArrayResource(id = R.array.article_categories)
    val pageCount = categoryList.size
    val currentIndex = pagerState.currentPage % pageCount
    var viewWidth by remember { mutableFloatStateOf(0f) }
    var viewHeight by remember { mutableFloatStateOf(0f) }
    var selectedIndex by remember { mutableIntStateOf(currentIndex) }
    var isTabSelected by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isTabSelected) {
        with(pagerState) {
            val target = selectedIndex
            animateScrollToPage(
                page = target,
                animationSpec = tween(
                    durationMillis = TAB_INDICATOR_ANIMATING_DURATION,
                    easing = FastOutSlowInEasing,
                )
            )
        }
    }

    OnTabChange(currentIndex, onCategoryChange, onSubCategoryChange)

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
                    isTabSelected = !isTabSelected
                    onPauseButtonClicked()
                }
            }
        }
    }
}

@Composable
private fun OnTabChange(
    currentIndex: Int,
    onCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
) {
    when (currentIndex) {
        0 -> {
            onCategoryChange(Category.SCIENCE)
            onSubCategoryChange(SubCategory.SCIENCE)
        }

        1 -> {
            onCategoryChange(Category.WORLD)
            onSubCategoryChange(SubCategory.ENVIRONMENT)
        }

        2 -> {
            onCategoryChange(Category.WORLD)
            onSubCategoryChange(SubCategory.ANIMAL)
        }

        3 -> {
            onCategoryChange(Category.WORLD)
            onSubCategoryChange(SubCategory.TRAVEL)
        }

        else -> {
            onCategoryChange(Category.GENERAL)
            onSubCategoryChange(SubCategory.DEFAULT)
        }
    }
}
