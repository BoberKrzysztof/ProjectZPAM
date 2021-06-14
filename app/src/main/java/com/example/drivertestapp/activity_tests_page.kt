package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_tests_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests_page)

        nextActivity()
    }


    private fun nextActivity() {
        val startButton = findViewById<Button>(R.id.Color_perception_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_color_test::class.java)
            startActivity(intent)
        }
    }
}