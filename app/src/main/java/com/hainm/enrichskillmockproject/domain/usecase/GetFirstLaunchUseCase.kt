package com.hainm.enrichskillmockproject.domain.usecase

import com.hainm.enrichskillmockproject.common.Result
import com.hainm.enrichskillmockproject.core.FlowUseCase
import com.hainm.enrichskillmockproject.di.coroutine.IoDispatcher
import com.hainm.enrichskillmockproject.domain.repository.SharedPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFirstLaunchUseCase @Inject constructor(
    private val sharedPreferenceRepository: SharedPreferenceRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
) : FlowUseCase<Unit, Boolean>(coroutineDispatcher) {
    override suspend fun execute(parameters: Unit): Flow<Result<Boolean>> = flow {
        emit(Result.Success(sharedPreferenceRepository.getFirstLaunch()))
    }
}