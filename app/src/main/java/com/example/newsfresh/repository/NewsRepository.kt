package com.example.newsfresh.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsfresh.api.NewsService
import com.example.newsfresh.models.NewsList

class NewsRepository(private val newsService: NewsService) {
private val newsLiveData=MutableLiveData<NewsList>()

     val news:LiveData<NewsList>
     get() = newsLiveData

    suspend fun getNews(){
        val result=newsService.getNews()
        if(result?.body()!=null){
            newsLiveData.postValue(result.body())
        }
    }

}