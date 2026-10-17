package com.example.prak // замените на ваш пакет, если он отличается (например, com.example.myapp)

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: экран создан")

        val etName = findViewById<EditText>(R.id.etName)
        val btnOpen = findViewById<Button>(R.id.btnOpen)

        btnOpen.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                Log.w(TAG, "Поле ввода имени пустое")
                Toast.makeText(this, "Пожалуйста, введите имя!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.i(TAG, "Нажата кнопка открытия списка, введено имя: $name")


            val intent = Intent(this, ListActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
            }
            startActivity(intent)
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "onStart") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "onResume") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "onPause") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }
}