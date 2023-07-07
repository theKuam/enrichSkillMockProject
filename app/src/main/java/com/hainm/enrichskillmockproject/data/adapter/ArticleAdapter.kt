package com.hainm.enrichskillmockproject.data.adapter

import com.hainm.enrichskillmockproject.data.entity.ArticleEntity
import com.hainm.enrichskillmockproject.data.entity.ArticlesEntity
import com.hainm.enrichskillmockproject.domain.model.Article

object ArticleAdapter {
    fun ArticlesEntity.toArticleList() = articles?.map { article ->
        article.toDomainArticle()
    } ?: listOf()

    private fun ArticleEntity.toDomainArticle() = Article(
        title = title,
        description = description,
        content = content,
        url = url,
        image = image,
        publishAt = publishAt,
        sourceName = source?.name,
        sourceUrl = source?.url,
    )
}