package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.DisableText
import com.hainm.enrichskillmockproject.ui.theme.IndicatorGreen
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun BodyTabRow(
    currentIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    ScrollableTabRow(
        modifier = Modifier.padding(horizontal = Spacing.large),
        edgePadding = 0.dp,
        selectedTabIndex = currentIndex,
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[currentIndex])
                    .height(Spacing.stroke)// clip modifier not working
                    .padding(horizontal = 28.dp)
                    .offset(y = -Spacing.smallMedium)
                    .background(
                        color = IndicatorGreen,
                        shape = RoundedCornerShape(Spacing.stroke),
                    )
            )
        },
        divider = {},
    ) {
        stringArrayResource(id = R.array.article_content).forEachIndexed { index, item ->
            Tab(
                text = {
                    Text(
                        text = item,
                        style = AppTextStyle.HomeWelcomeUserNormal,
                        color = if (currentIndex == index) IndicatorGreen else DisableText,
                    )
                },
                selected = currentIndex == index,
                onClick = { onTabSelected(index) },
            )
        }
    }
}