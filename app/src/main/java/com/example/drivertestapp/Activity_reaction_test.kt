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

class Activity_reaction_test : AppCompatActivity() {

    var tMilliSec = 0L
    var tBuff = 0L
    var tStart = 0L
    var tUpdate = 0L
    var sec: Int = 0
    var milliSec: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_test)
        val startButton = findViewById<Button>(R.id.start_button)
        val stopButton = findViewById<Button>(R.id.circle_button)
        val result = findViewById<TextView>(R.id.best_result)

        startButton.setOnClickListener {
            run(result)
        }

    }

    private fun run(res: TextView){
        tMilliSec = SystemClock.uptimeMillis() - tStart
        tUpdate = tBuff + tMilliSec
        milliSec = (tUpdate%1000).toInt()
        res.text = String.format("%03d",milliSec)
    }
}
