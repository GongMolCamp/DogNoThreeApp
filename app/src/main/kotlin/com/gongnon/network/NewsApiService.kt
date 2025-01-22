package com.gongnon.network

import com.gongnon.model.NewsArticle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiService {
    @GET("news/{id}")
    fun getNewsById(@Path("id") id: Long): Call<NewsArticle>
}