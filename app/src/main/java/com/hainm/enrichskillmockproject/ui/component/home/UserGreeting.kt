package com.hainm.enrichskillmockproject.ui.component.home.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun RowScope.UserGreeting() {
    Column(
        modifier = Modifier
            .align(Alignment.Bottom)
            .padding(top = Spacing.small)
    ) {
        Text(
            text = stringResource(id = R.string.home_welcome_user_1),
            style = AppTextStyle.HomeWelcomeUserBold,
        )
        Text(
            text = stringResource(id = R.string.home_welcome_user_2),
            style = AppTextStyle.HomeWelcomeUserNormal,
        )
    }
}