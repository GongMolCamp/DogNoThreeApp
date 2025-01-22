package com.gongnon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.gongnon.ui.NewsDetailActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            // NewsDetailActivity로 바로 이동
            val intent = Intent(this, NewsDetailActivity::class.java)
            intent.putExtra("newsId", 1L) // 1번 뉴스 ID
            startActivity(intent)

            // MainActivity 종료
            finish()
        } catch (e: Exception) {
            Log.e("MainActivity", "Error launching NewsDetailActivity", e)
            Toast.makeText(this, "Error starting app", Toast.LENGTH_SHORT).show()
        }
    }
}