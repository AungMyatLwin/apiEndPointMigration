package com.rig.apiendpoint

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilder {
    private val base_uri = "https://api.publicapis.org/"

    @Provides
    fun provideRetrofitBuilder(): Retrofit = Retrofit.Builder().baseUrl(base_uri)
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun providesRepository(apiService: ApiService) = Repository(apiService)

}