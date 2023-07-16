package com.example.thefoodblog.model

import com.example.thefoodblog.data.Article
import com.example.thefoodblog.network.NewsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

suspend fun fetchNewsHeadlinesFromApi(): List<Article> {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(NewsApiService::class.java)

    val response = service.getTopHeadlines("us", "75c62a8c721c4bf087a5e71c5202bade")
    if (response.isSuccessful) {
        return response.body()?.articles ?: emptyList()
    } else {

        throw Exception("Failed to fetch news headlines: ${response.message()}")  //API ERROR
    }
}
