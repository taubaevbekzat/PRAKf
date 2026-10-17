package com.example.prak

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate")

        val studentName = intent.getStringExtra(ListActivity.EXTRA_STUDENT) ?: "Неизвестно"
        val grade = intent.getIntExtra(ListActivity.EXTRA_GRADE, 0)

        Log.d(TAG, "Получены данные: студент — $studentName, оценка — $grade")

        findViewById<TextView>(R.id.tvStudentName).text = studentName
        findViewById<TextView>(R.id.tvGrade).text = "Оценка: $grade (Отлично)"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            Log.i(TAG, "Нажата кнопка Назад")
            finish()
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}