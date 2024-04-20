package com.ny.mvvm_views.domain

import com.ny.mvvm_views.data.QuoteRepository
import com.ny.mvvm_views.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
//    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}