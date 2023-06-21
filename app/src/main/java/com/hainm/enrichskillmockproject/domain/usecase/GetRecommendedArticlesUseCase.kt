package com.hainm.enrichskillmockproject.domain.usecase

import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.core.FlowUseCase
import com.hainm.enrichskillmockproject.data.model.Articles
import com.hainm.enrichskillmockproject.di.coroutine.IoDispatcher
import com.hainm.enrichskillmockproject.domain.repository.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecommendedArticlesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
) : FlowUseCase<Parameters, Articles>(coroutineDispatcher) {

    override suspend fun execute(parameters: Parameters): Flow<Outcome<Articles>> =
        homeRepository.getRecommendedArticles(parameters.category, parameters.subCategory)
}

data class Parameters(
    val category: String,
    val subCategory: String,
)