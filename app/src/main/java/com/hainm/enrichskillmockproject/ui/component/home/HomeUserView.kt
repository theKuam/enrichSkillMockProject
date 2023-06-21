package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.ui.component.home.user.UserAvatar
import com.hainm.enrichskillmockproject.ui.component.home.user.UserGreeting

@Composable
fun HomeUserView() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        UserGreeting()
        UserAvatar()
    }
}