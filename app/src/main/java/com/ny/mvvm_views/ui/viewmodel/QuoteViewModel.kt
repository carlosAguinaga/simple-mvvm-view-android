package com.ny.mvvm_views.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ny.mvvm_views.data.model.QuoteModel
import com.ny.mvvm_views.data.model.QuoteProvider
import com.ny.mvvm_views.domain.GetQuoteUseCase
import com.ny.mvvm_views.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase: GetQuoteUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

//    var getQuoteUseCase = GetQuoteUseCase()
//    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<QuoteModel>? = getQuoteUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
//        val currentQuote: QuoteModel = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }



}