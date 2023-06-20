package com.hainm.enrichskillmockproject.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.hainm.enrichskillmockproject.R

object AppTextStyle {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_light, FontWeight.Light), // 300
        Font(R.font.poppins, FontWeight.Normal), // 400
        Font(R.font.poppins_semibold, FontWeight.SemiBold), // 600
        Font(R.font.poppins_bold, FontWeight.Bold) // 700
    )

    private val nunitoSansFamily = FontFamily(
        Font(R.font.nunito_sans, FontWeight.Normal), // 400
        Font(R.font.nunito_sans_semibold, FontWeight.SemiBold), // 600
        Font(R.font.nunito_sans_bold, FontWeight.Bold) // 700
    )

    @Stable
    val WelcomeTitle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 29.sp,
        lineHeight = 45.sp,
    )

    @Stable
    val WelcomeDescription = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.05.em,
    )

    @Stable
    val WelcomeButton = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 23.sp,
    )
}