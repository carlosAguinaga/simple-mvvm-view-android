package com.ny.mvvm_views.data

import com.ny.mvvm_views.data.model.QuoteModel
import com.ny.mvvm_views.data.model.QuoteProvider
import com.ny.mvvm_views.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}