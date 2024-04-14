package com.ny.mvvm_views.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ny.mvvm_views.model.QuoteModel
import com.ny.mvvm_views.model.QuoteProvider

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote: QuoteModel = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

}