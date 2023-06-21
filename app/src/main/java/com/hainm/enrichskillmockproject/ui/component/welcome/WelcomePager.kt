package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_PAGE_COUNT
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun WelcomePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onPageChanged: (Float) -> Unit,
) {
    HorizontalPager(
        state = pagerState,
        pageCount = CAROUSEL_PAGE_COUNT,
    ) { index ->
        onPageChanged(pagerState.currentPage.toFloat() / CAROUSEL_PAGE_COUNT)
        val (title, description) = when (index) {
            0 -> stringResource(id = R.string.welcome_title_1) to stringResource(id = R.string.welcome_desc_1)
            1 -> stringResource(id = R.string.welcome_title_2) to stringResource(id = R.string.welcome_desc_2)
            2 -> stringResource(id = R.string.welcome_title_3) to stringResource(id = R.string.welcome_desc_3)
            3 -> stringResource(id = R.string.welcome_title_4) to stringResource(id = R.string.welcome_desc_4)
            else -> stringResource(id = R.string.welcome_title_default) to stringResource(id = R.string.welcome_desc_default)
        }
        Column(
            modifier = modifier
                .fillMaxHeight()
                .padding(bottom = 200.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = title,
                style = AppTextStyle.WelcomeTitle,
            )
            Spacer(modifier = Modifier.height(Spacing.smallMedium))
            Text(
                text = description,
                style = AppTextStyle.WelcomeDescription,
            )
        }
    }
}