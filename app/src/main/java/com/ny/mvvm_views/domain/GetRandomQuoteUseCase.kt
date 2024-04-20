package com.ny.mvvm_views.domain

import com.ny.mvvm_views.data.model.QuoteModel
import com.ny.mvvm_views.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(){
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            var randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}