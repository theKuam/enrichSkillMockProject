package com.hainm.enrichskillmockproject.domain.usecase

import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.core.FlowUseCase
import com.hainm.enrichskillmockproject.di.coroutine.IoDispatcher
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.domain.repository.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetRecommendedArticlesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
) : FlowUseCase<Parameters, List<Article>>(coroutineDispatcher) {
    override suspend fun execute(parameters: Parameters): Flow<Outcome<List<Article>>> = flow {
        val response =
            homeRepository.getRecommendedArticles(parameters.category, parameters.subCategory)
        emit(Outcome.Success(response))
    }
        .flowOn(coroutineDispatcher)
}

data class Parameters(
    val category: String,
    val subCategory: String,
)