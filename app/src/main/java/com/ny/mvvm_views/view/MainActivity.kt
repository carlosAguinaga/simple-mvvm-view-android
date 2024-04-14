package com.ny.mvvm_views.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ny.mvvm_views.databinding.ActivityMainBinding
import com.ny.mvvm_views.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    //private val quoteViewModel: QuoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer{ currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        binding.viewContainer.setOnClickListener{ quoteViewModel.randomQuote() }
    }
}