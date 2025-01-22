package com.gongnon.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gongnon.databinding.ActivityNewsDetailBinding
import com.gongnon.model.NewsArticle
import com.gongnon.network.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsDetailActivity : AppCompatActivity() {

    private val TAG = "NewsDetailActivity"
    private lateinit var binding: ActivityNewsDetailBinding
    private lateinit var apiService: NewsApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding 초기화
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: Activity started")

        val newsId = intent.getLongExtra("newsId", -1L)
        if (newsId == -1L) {
            Toast.makeText(this, "Invalid newsId", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.212:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(NewsApiService::class.java)
        loadNewsDetails(newsId)
    }

    private fun loadNewsDetails(id: Long) {
        apiService.getNewsById(id).enqueue(object : Callback<NewsArticle> {
            override fun onResponse(call: Call<NewsArticle>, response: Response<NewsArticle>) {
                if (response.isSuccessful && response.body() != null) {
                    val article = response.body()!!
                    binding.titleTextView.text = article.title ?: "No Title"
                    Glide.with(this@NewsDetailActivity)
                        .load(article.link)
                        .into(binding.articleImageView)
                    binding.descriptionTextView.text = article.description ?: "No Description"
                } else {
                    Log.e(TAG, "API call failed: ${response.code()}")
                    Toast.makeText(this@NewsDetailActivity, "Failed to load news", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsArticle>, t: Throwable) {
                Log.e(TAG, "API call failed", t)
                Toast.makeText(this@NewsDetailActivity, "Failed to load news", Toast.LENGTH_SHORT).show()
            }
        })
    }
}