package com.example.prak

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ListActivity"
        const val EXTRA_STUDENT = "extra_student"
        const val EXTRA_GRADE = "extra_grade"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        Log.d(TAG, "onCreate")


        val userName = intent.getStringExtra(MainActivity.EXTRA_NAME) ?: "Гость"
        Toast.makeText(this, "Добро пожаловать, $userName!", Toast.LENGTH_SHORT).show()

        val btnStudent1 = findViewById<Button>(R.id.btnStudent1)
        val btnStudent2 = findViewById<Button>(R.id.btnStudent2)

        btnStudent1.setOnClickListener {
            Log.i(TAG, "Выбран студент: Асанов Айдос")
            openDetail("Асанов Айдос", 92)
        }

        btnStudent2.setOnClickListener {
            Log.i(TAG, "Выбран студент: Серикұлы Ернар")
            openDetail("Серикұлы Ернар", 85)
        }
    }

    private fun openDetail(studentName: String, grade: Int) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_STUDENT, studentName)
            putExtra(EXTRA_GRADE, grade)
        }
        startActivity(intent)
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}