package com.gongnon

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.widget.ImageButton

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // 전화번호, 관심사 입력
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val interestInput = findViewById<EditText>(R.id.interestInput)

        // 알림 시간 설정
        val timePickerButton = findViewById<Button>(R.id.timePickerButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // 현재 액티비티 종료
        }


        // TimePickerDialog를 사용하여 시간 설정
        timePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->
                    val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                    timePickerButton.text = "알림 시간: $formattedTime"
                },
                hour,
                minute,
                false // 24시간 형식 사용 여부
            )
            timePickerDialog.show()
        }

        // 저장 버튼 클릭 이벤트
        saveButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            val interest = interestInput.text.toString()
            val time = timePickerButton.text.toString()

            if (phone.isEmpty() || interest.isEmpty() || !time.contains("알림 시간")) {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "저장되었습니다!", Toast.LENGTH_SHORT).show()
                // 저장 로직 추가 (DB 또는 SharedPreferences 사용)
                finish()
            }
        }
    }
}
