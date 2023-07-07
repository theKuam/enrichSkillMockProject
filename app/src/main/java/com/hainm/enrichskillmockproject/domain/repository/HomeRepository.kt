package com.hainm.enrichskillmockproject.domain.repository

import com.hainm.enrichskillmockproject.domain.model.Article

interface HomeRepository {
    suspend fun getRecommendedArticles(category: String, subCategory: String): List<Article>
}