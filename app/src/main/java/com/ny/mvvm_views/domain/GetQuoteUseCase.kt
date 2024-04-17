package com.ny.mvvm_views.domain

import com.ny.mvvm_views.data.QuoteRepository
import com.ny.mvvm_views.data.model.QuoteModel

class GetQuoteUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}