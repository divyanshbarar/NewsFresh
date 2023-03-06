package com.example.newsfresh.api

import com.example.newsfresh.models.NewsList
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {


    @GET("v2/top-headlines?country=us&apiKey=59545d0758af4156853db66879e722a3")
    suspend fun getNews():Response<NewsList>

}