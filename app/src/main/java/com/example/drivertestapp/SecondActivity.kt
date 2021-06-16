package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        loginOpen()
        registerActivityOpen()
        nextActivity()
    }
    private fun loginOpen(){
        val login = findViewById<Button>(R.id.loginButton)
        login.setOnClickListener {
            val intent = Intent(this, activity_tests_page::class.java)
            startActivity(intent)
        }
    }
    private fun registerActivityOpen() {
        val registerLabel = findViewById<TextView>(R.id.registerLabel)
        registerLabel.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun nextActivity() {
        val startButton = findViewById<Button>(R.id.loginButton)
        startButton.setOnClickListener {
            val intent = Intent(this, activity_tests_page::class.java)
            startActivity(intent)
        }
    }
}