package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.TAB_INDICATOR_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.ui.theme.AppBackgroundLower
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.NavigationIcon
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HomeNavigateBottomView(
    currentIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    var tabIndex by remember { mutableStateOf(currentIndex) }
    LaunchedEffect(key1 = currentIndex) {
        tabIndex = currentIndex
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(AppBackgroundLower)
    ) {

        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = Color.Transparent,
            indicator = { tabPositions ->
                TabIndicator(
                    color = IndicatorGreen,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                )
            },
            divider = {},
        ) {
            stringArrayResource(id = R.array.home_navigation).forEachIndexed { index, item ->
                val navigationIconSize by animateDpAsState(
                    targetValue = if (tabIndex == index) 22.dp else Spacing.medium,
                    animationSpec = tween(
                        durationMillis = TAB_INDICATOR_ANIMATING_DURATION,
                        easing = FastOutSlowInEasing
                    ),
                )
                val image = when (index) {
                    0 -> {
                        R.drawable.home_24
                    }

                    1 -> {
                        R.drawable.compass_24
                    }

                    2 -> {
                        R.drawable.bell_24
                    }

                    3 -> {
                        R.drawable.user_24
                    }

                    else -> {
                        R.drawable.user_24
                    }
                }
                Tab(
                    icon = {
                        Image(
                            modifier = Modifier.height(navigationIconSize),
                            painter = painterResource(id = image),
                            contentDescription = item,
                            colorFilter = ColorFilter.tint(
                                color = if (tabIndex == index) IndicatorGreen else NavigationIcon
                            )
                        )
                    },
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                        onTabSelected(index)
                    },
                )
            }
        }
    }
}

@Composable
fun TabIndicator(
    modifier: Modifier,
    color: Color,
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(Spacing.extraSmall)
                .background(color = color, shape = CircleShape)
                .align(Alignment.Center)
        )
    }
}