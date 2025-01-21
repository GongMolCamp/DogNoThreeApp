package com.gongnon

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        // 뒤로가기 버튼
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // 현재 Activity 종료
        }

        // 수정 버튼
        val editButton = findViewById<Button>(R.id.editButton)
        editButton.setOnClickListener {
            Toast.makeText(this, "수정 버튼 클릭!", Toast.LENGTH_SHORT).show()
        }

        // 뉴스 보기 버튼
        val viewNewsButton = findViewById<Button>(R.id.viewNewsButton)
        viewNewsButton.setOnClickListener {
            Toast.makeText(this, "뉴스 보기 버튼 클릭!", Toast.LENGTH_SHORT).show()
        }
    }
}
