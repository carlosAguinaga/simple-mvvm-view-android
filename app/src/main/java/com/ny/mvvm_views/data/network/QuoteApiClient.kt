package com.ny.mvvm_views.data.network

import com.ny.mvvm_views.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}