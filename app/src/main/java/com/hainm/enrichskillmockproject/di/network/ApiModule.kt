package com.hainm.enrichskillmockproject.di.network

import com.hainm.enrichskillmockproject.BuildConfig
import com.hainm.enrichskillmockproject.service.ArticleService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = "https://gnews.io/api/v4/"

    @Provides
    @Named("OKHTTP_CLIENT")
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val url = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("apikey", BuildConfig.API_KEY)
                .build()
            chain.proceed(chain.request().newBuilder().url(url).build())
        }
        .build()

    @Provides
    @Named("MOSHI")
    fun moshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Named("RETROFIT")
    fun provideRetrofit(
        @Named("BASE_URL") baseUrl: String,
        @Named("OKHTTP_CLIENT") client: OkHttpClient,
        @Named("MOSHI") moshi: Moshi,
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }

    @Provides
    fun provideArticleService(
        @Named("RETROFIT") retrofit: Retrofit,
    ): ArticleService = retrofit.create(ArticleService::class.java)
}