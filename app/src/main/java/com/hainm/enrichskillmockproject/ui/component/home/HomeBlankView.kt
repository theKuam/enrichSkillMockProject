package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.EMPTY_STRING
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HomeBlankView(tabIndex: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Coming Soon",
                style = AppTextStyle.WelcomeTitle,
            )
            val image = when (tabIndex) {
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

            Spacer(modifier = Modifier.width(Spacing.small))

            Image(
                modifier = Modifier.height(Spacing.extraLarge),
                painter = painterResource(id = image),
                contentDescription = EMPTY_STRING,
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }
    }
}