package com.ny.mvvm_views.data

import com.ny.mvvm_views.data.model.QuoteModel
import com.ny.mvvm_views.data.model.QuoteProvider
import com.ny.mvvm_views.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor( private val api: QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}