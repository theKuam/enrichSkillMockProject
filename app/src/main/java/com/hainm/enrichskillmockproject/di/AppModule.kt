package com.hainm.enrichskillmockproject.di

import com.hainm.enrichskillmockproject.BuildConfig
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
class AppModule {

    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = "https://gnews.io/api/v4/"

    @Provides
    @Named("OKHTTP_CLIENT")
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val url = chain
                .request()
                .url()
                .newBuilder()
                .addQueryParameter("apikey", BuildConfig.API_KEY)
                .build()
            chain.proceed(chain.request().newBuilder().url(url).build())
        }
        .build()


    @Provides
    fun provideRetrofit(
        @Named("BASE_URL") baseUrl: String,
        @Named("OKHTTP_CLIENT") client: OkHttpClient,
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }
}