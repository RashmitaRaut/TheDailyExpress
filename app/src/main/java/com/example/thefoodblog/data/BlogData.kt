package com.example.thefoodblog.data

data class BlogData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)