package com.example.drivertestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast

class Activity_reaction_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_test)
        val startButton = findViewById<Button>(R.id.start_button)
        val stopButton = findViewById<Button>(R.id.circle_button)
        val result = findViewById<TextView>(R.id.best_result)


        startButton.setOnClickListener {
            run()
        }

    }

    private fun run(){

    }
}
