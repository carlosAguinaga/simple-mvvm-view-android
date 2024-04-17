package com.ny.mvvm_views.data.network

import com.ny.mvvm_views.core.RetrofitHelper
import com.ny.mvvm_views.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.gerRetrofit()
    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body()?: emptyList()
        }

    }
}