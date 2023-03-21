package com.example.jsondata.instance

import com.example.jsondata.api.ApiCall
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun getInstance(): ApiCall {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiCall::class.java)
    }

}