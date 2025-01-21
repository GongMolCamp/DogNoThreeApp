package com.gongnon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // 입력 필드와 버튼 참조
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val newsPreferenceInput = findViewById<EditText>(R.id.newsPreferenceInput)
        val notificationTimeInput = findViewById<EditText>(R.id.notificationTimeInput)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // 등록 버튼 클릭 이벤트
        registerButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val name = nameInput.text.toString()
            val phone = phoneInput.text.toString()
            val newsPreference = newsPreferenceInput.text.toString()
            val notificationTime = notificationTimeInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() &&
                phone.isNotEmpty() && newsPreference.isNotEmpty() && notificationTime.isNotEmpty()) {
                Toast.makeText(this, "회원가입 성공! ($username)", Toast.LENGTH_SHORT).show()
                finish() // 현재 페이지 종료
            } else {
                Toast.makeText(this, "모든 필드를 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }

        // 뒤로 버튼 클릭 이벤트
        backButton.setOnClickListener {
            finish() // 현재 페이지 종료하여 메인 페이지로 돌아감
        }
    }
}
