package com.example.newsfresh

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfresh.api.NewsService
import com.example.newsfresh.api.RetroFitHelper
import com.example.newsfresh.databinding.ActivityMainBinding
import com.example.newsfresh.models.Article
import com.example.newsfresh.repository.NewsRepository
import com.example.newsfresh.viewmodel.MainViewModel
import com.example.newsfresh.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var newsRepository: NewsRepository
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val newsService=RetroFitHelper.getInstance().create(NewsService::class.java)
        newsRepository=NewsRepository(newsService)

        mainViewModel=ViewModelProvider(this,MainViewModelFactory(newsRepository)).get(MainViewModel::class.java)

        mainViewModel.news.observe(this) {
            Log.d("divyansh", it.articles.toString())
            adapter= NewsAdapter(this,it.articles,this)
            binding.newsList.adapter=adapter
            binding.newsList.layoutManager=LinearLayoutManager(this)
        }
    }


    fun onItemClicked(item: Article) {
        val builder =  CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }

}