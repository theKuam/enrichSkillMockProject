package com.hainm.enrichskillmockproject.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
        fontSize = 30.sp,
        color = WhiteText,
    )

    @Stable
    val WelcomeDescription = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        letterSpacing = 0.7.sp,
        color = WhiteGreyText,
    )

    @Stable
    val WelcomeButton = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = Color.White,
    )

    @Stable
    val HomeWelcomeUserBold = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = Color.White,
    )

    @Stable
    val HomeWelcomeUserNormal = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = LightGreyText,
    )

    @Stable
    val HomeCarouselTitle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = WhiteText,
    )

    @Stable
    val HomeCategoryTitle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = WhiteText,
    )

    @Stable
    val RecommendedArticle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = WhiteText,
    )

    @Stable
    val ShowAll = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        color = IndicatorGreen,
    )

    @Stable
    val NunitoCommonText = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 9.sp,
        color = Color.White,
    )

    @Stable
    val NunitoMediumText = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        color = Color.White,
    )

    @Stable
    val NunitoSubtitleText = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 6.sp,
        letterSpacing = 0.3.sp,
        color = Color.White,
    )

    @Stable
    val ArticleTitle = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.White,
    )

    @Stable
    val NunitoLightMediumText = TextStyle(
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = Color.White,
    )

    @Stable
    val ContentText = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = ContentTextColor,
    )
}