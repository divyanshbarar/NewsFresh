package com.example.newsfresh.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroFitHelper {
    private const val BASE_URL = "https://newsapi.org/"

    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
