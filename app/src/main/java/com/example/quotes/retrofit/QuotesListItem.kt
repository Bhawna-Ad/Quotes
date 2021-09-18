package com.example.quotes.retrofit

import com.google.gson.annotations.SerializedName

data class QuotesListItem(
    @SerializedName("body")
    val author: String,
    val text: String
)