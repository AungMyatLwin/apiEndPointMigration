package com.rig.apiendpoint

import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("entries")
    suspend fun getAllEntries():Test
    @GET("random")
    suspend fun getSurprise():Test
    @GET("categories")
    suspend fun getCategories():Categories
}