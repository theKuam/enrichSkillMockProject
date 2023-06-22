package com.hainm.enrichskillmockproject.ui.component.common.hometab

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_ANIMATING_DURATION
import com.hainm.enrichskillmockproject.common.util.SubComposableId
import com.hainm.enrichskillmockproject.ui.theme.AppBackground
import com.hainm.enrichskillmockproject.ui.theme.HomeCategoryBackground
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HomeTabRow(
    width: Float,
    height: Float,
    containerColor: Color = HomeCategoryBackground,
    indicatorColor: Color = AppBackground,
    containerShape: Shape = RoundedCornerShape(size = Spacing.small),
    indicatorShape: Shape = HomeTabIndicatorShape(Spacing.small),
    paddingValues: PaddingValues = PaddingValues(Spacing.extraSmall),
    animationSpec: AnimationSpec<Dp> = tween(
        durationMillis = CAROUSEL_AUTOPLAY_ANIMATING_DURATION,
        easing = FastOutSlowInEasing
    ),
    selectedTabPosition: Int = 0,
    tabItem: @Composable () -> Unit,
) {
    Surface(
        color = containerColor,
        shape = containerShape,
    ) {
        SubcomposeLayout(
            Modifier
                .padding(paddingValues)
                .selectableGroup(),
        ) { constraints ->
            val tabMeasurable: List<Placeable> =
                subcompose(SubComposableId.PRECALCULATE_ITEM, tabItem)
                    .map { it.measure(constraints) }

            val itemCount = tabMeasurable.size
            val maxItemHeight = height.toInt()

            val tabPlaces = subcompose(SubComposableId.ITEM, tabItem).map {
                it.measure(constraints)
            }
            val margin = (width - tabPlaces.sumOf { it.width }) / itemCount

            val tabPositions = tabMeasurable.mapIndexed { index, measurable ->
                val itemWidth = measurable.width + margin + Spacing.small.toPx() * 2
                val leftTabWith = tabMeasurable.take(index)
                    .sumOf { it.width } + margin * index - Spacing.small.toPx()
                TabPosition(leftTabWith.toDp(), itemWidth.toDp())
            }

            val tabRowWidth = width.toInt()

            layout(tabRowWidth, maxItemHeight) {
                subcompose(SubComposableId.INDICATOR) {
                    var indicatorWidth by remember { mutableStateOf(0f) }
                    Box(
                        modifier = Modifier
                            .homeTabIndicator(tabPositions[selectedTabPosition], animationSpec)
                            .fillMaxWidth()
                            .height(maxItemHeight.toDp() + Spacing.extraSmall)
                            .background(color = indicatorColor, indicatorShape)
                            .onGloballyPositioned { coordinates ->
                                indicatorWidth = coordinates.size.width.toFloat()
                            }
                    ) {
                        Divider(
                            modifier = Modifier
                                .width(indicatorWidth.toDp() - Spacing.extraLarge * 2)
                                .align(Alignment.BottomCenter)
                                .offset(y = (-9).dp),
                            color = IndicatorGreen,
                            thickness = Spacing.stroke,
                        )
                    }
                }.forEach {
                    it.measure(Constraints.fixed(tabRowWidth, maxItemHeight)).placeRelative(0, 0)
                }

                tabPlaces.forEachIndexed { index, placeable ->
                    val leftTabWith = tabPlaces.take(index).sumOf { it.width } + margin * index
                    placeable.placeRelative(
                        leftTabWith.toInt() + margin.toInt() / 2,
                        14.dp.toPx().toInt()
                    )
                }
            }
        }
    }
}