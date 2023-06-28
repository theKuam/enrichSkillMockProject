package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.ui.component.article.ArticleBackground
import com.hainm.enrichskillmockproject.ui.component.article.ArticleButtons
import com.hainm.enrichskillmockproject.ui.component.article.ArticleContent
import com.hainm.enrichskillmockproject.ui.model.ArticleModel

@ExperimentalMotionApi
@ExperimentalFoundationApi
@Composable
fun ArticleScreen(
    article: ArticleModel,
    onBackPressed: () -> Unit,
) {
    val progress = 0f
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    BaseScreen {
        MotionLayout(
            modifier = Modifier.fillMaxSize(),
            motionScene = MotionScene(content = motionScene),
            progress = progress,
        ) {
            val bodyPagerBg = customColor("bodyPager", "backgroundColor")
            val bodyHeaderBg = customColor("header", "backgroundColor")
            val textColor = customColor("bodyPager", "textColor")

            ArticleBackground(article)

            ArticleContent(
                article,
                bodyHeaderBg,
                bodyPagerBg,
                textColor,
            )

            ArticleButtons(onBackPressed)
        }
    }
}
