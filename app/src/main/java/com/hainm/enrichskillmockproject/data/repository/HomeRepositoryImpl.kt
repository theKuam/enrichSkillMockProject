package com.hainm.enrichskillmockproject.data.repository

import com.hainm.enrichskillmockproject.data.adapter.ArticleAdapter.toArticleList
import com.hainm.enrichskillmockproject.data.datasource.remote.service.ArticleService
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val articleService: ArticleService) :
    HomeRepository {
    override suspend fun getRecommendedArticles(
        category: String,
        subCategory: String,
    ): List<Article> = articleService.getRecommendedArticles(category, subCategory).toArticleList()
}