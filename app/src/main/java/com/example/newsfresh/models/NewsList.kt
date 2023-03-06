package com.example.newsfresh.models

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)