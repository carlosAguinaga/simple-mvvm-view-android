package com.ny.mvvm_views.domain

import com.ny.mvvm_views.data.QuoteRepository
import com.ny.mvvm_views.data.model.QuoteModel
import com.ny.mvvm_views.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            var randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}