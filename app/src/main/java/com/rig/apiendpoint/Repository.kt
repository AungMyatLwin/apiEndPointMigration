package com.rig.apiendpoint

import dagger.hilt.InstallIn
import okhttp3.Response
import javax.inject.Inject

class Repository @Inject constructor(var apiService: ApiService) {
    suspend fun getAllEntries() = apiService.getAllEntries()
    suspend fun getSurprise() = apiService.getSurprise()
    suspend fun getCategories() = apiService.getCategories()
}