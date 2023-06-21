package com.hainm.enrichskillmockproject.ui.component.home.user

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun RowScope.UserAvatar() {
    Image(
        modifier = Modifier
            .align(Alignment.Top)
            .size(42.dp)
            .clip(shape = CircleShape)
            .border(
                border = BorderStroke(
                    width = Spacing.big_stroke,
                    brush = SolidColor(Color.White),
                ),
                shape = CircleShape,
            ),
        painter = painterResource(id = R.drawable.home_avatar),
        contentScale = ContentScale.Crop,
        contentDescription = "home avatar",
    )
}