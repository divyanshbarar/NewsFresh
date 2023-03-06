package com.example.newsfresh.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsfresh.models.NewsList
import com.example.newsfresh.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NewsRepository):ViewModel() {
    init{
        viewModelScope.launch(Dispatchers.IO){
            repository.getNews()
        }
    }
    val news:LiveData<NewsList>
    get()=repository.news
}