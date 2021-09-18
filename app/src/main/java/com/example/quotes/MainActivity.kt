package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quotes.constants.BASE_URL
import com.example.quotes.interfaces.RetrofitService
import com.example.quotes.retrofit.QuotesListItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitService::class.java)

        val retrofitData = retrofitBuilder.getQuotes()
        retrofitData.enqueue(object: Callback<List<QuotesListItem>?> {
            override fun onResponse(
                call: Call<List<QuotesListItem>?>,
                response: Response<List<QuotesListItem>?>
            ) {
                val stringBuilder = StringBuilder()
                val responseBody = response.body()!!
                val data = responseBody.random()
                stringBuilder.append(data.text).append("\n")
                Quotes.text = stringBuilder
            }

            override fun onFailure(call: Call<List<QuotesListItem>?>, t: Throwable) {
            }
        })
    }
}