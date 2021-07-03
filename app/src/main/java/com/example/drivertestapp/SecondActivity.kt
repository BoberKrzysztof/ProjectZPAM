package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val login = findViewById<Button>(R.id.loginButton)
        login.setOnClickListener {
            loginOpen()
        }
        registerActivityOpen()
    }

    private fun loginOpen() {
        val eLogin = findViewById<EditText>(R.id.loginEditText)
        val log = eLogin.text.toString()
        val ePassword = findViewById<EditText>(R.id.passwordEditText)
        val pas = ePassword.text.toString()
        val databaseHelper = DataBaseHelper(this)

        if (log.isEmpty() || pas.isEmpty()) {
            Toast.makeText(this, "Enter login and password", Toast.LENGTH_SHORT).show()
        } else {
            val loginPassword = databaseHelper.signIn(log, pas)
            if (loginPassword){
                val intent = Intent(this, activity_tests_page::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerActivityOpen() {
        val registerLabel = findViewById<TextView>(R.id.registerLabel)
        registerLabel.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}