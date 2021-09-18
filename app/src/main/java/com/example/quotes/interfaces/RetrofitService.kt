package com.example.quotes.interfaces

import com.example.quotes.retrofit.QuotesListItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("quotes")
    fun getQuotes(): Call<List<QuotesListItem>>
}