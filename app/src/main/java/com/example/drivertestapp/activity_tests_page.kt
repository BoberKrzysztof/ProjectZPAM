package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class activity_tests_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests_page)

        nextActivityColor()
        nextActivityReaction()
        nextActivityIntelligent()
        nextActivityCISS()
        inteligenceResult()
        CISSResult()
    }


    private fun nextActivityColor() {
        val startButton = findViewById<Button>(R.id.Color_perception_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_color_test::class.java)
            startActivity(intent)
        }
    }

    private fun nextActivityReaction() {
        val startButton = findViewById<Button>(R.id.Reaction_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_reaction_test::class.java)
            startActivity(intent)
        }
    }

    private fun nextActivityIntelligent() {
        val startButton = findViewById<Button>(R.id.Inteligence_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_intelligent_test::class.java)
            startActivity(intent)
            startButton.setEnabled(false)
        }
    }

    private fun nextActivityCISS() {
        val startButton = findViewById<Button>(R.id.CISS_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_CISS::class.java)
            startActivity(intent)
            startButton.setEnabled(false)
        }
    }

    private fun inteligenceResult() {
        val result = findViewById<TextView>(R.id.inteligence_result)
        val progres = findViewById<ProgressBar>(R.id.progressBar_inteligence_testPage)
        val sum = Storage.sum2

        result.append(sum.toString())
        result.append("/30")

        progres.setProgress(sum * (100 / 30))
    }

    private fun CISSResult() {

    }
}