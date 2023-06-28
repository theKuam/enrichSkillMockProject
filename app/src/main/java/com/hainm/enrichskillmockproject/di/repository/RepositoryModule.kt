package com.hainm.enrichskillmockproject.di.repository

import com.hainm.enrichskillmockproject.data.repository.HomeRepositoryImpl
import com.hainm.enrichskillmockproject.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl,
    ): HomeRepository
}