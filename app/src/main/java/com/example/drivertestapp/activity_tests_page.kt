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

        if(Storage.color_attempt) {
            nextActivityColor()

        }
        if (Storage.inteligence_attempt) {
            nextActivityIntelligent()

        }
        if (Storage.CISS_attempt) {
            nextActivityCISS()

        }
        if(Storage.reaction_attempt) {
            nextActivityReaction()

        }
        inteligenceResult()
        CISSResult()
        ColorResult()
    }


    private fun nextActivityColor() {
        val startButton = findViewById<Button>(R.id.Color_perception_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_color_test::class.java)
            startActivity(intent)
            Storage.color_attempt = false
        }
    }

    private fun nextActivityReaction() {
        val startButton = findViewById<Button>(R.id.Reaction_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_reaction_test::class.java)
            startActivity(intent)
            Storage.reaction_attempt = false
        }
    }

    private fun nextActivityIntelligent() {
        val startButton = findViewById<Button>(R.id.Inteligence_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_intelligent_test::class.java)
            startActivity(intent)
            Storage.inteligence_attempt = false
        }
    }

    private fun nextActivityCISS() {
        val startButton = findViewById<Button>(R.id.CISS_test_button)
        startButton.setOnClickListener {
            val intent = Intent(this, Activity_CISS::class.java)
            startActivity(intent)
            Storage.CISS_attempt = false
        }
    }

    private fun inteligenceResult() {
        val result = findViewById<TextView>(R.id.inteligence_result)
        val progres = findViewById<ProgressBar>(R.id.progressBar_inteligence_testPage)
        val sum = Storage.sum2

        result.append(sum.toString())
        result.append("/30")

        progres.setProgress(sum * (120 / 30))
    }

    private fun CISSResult() {

    }

    private fun ColorResult(){
        val result = findViewById<TextView>(R.id.result_color_testpage)
        val progres = findViewById<ProgressBar>(R.id.progressBar_color_testpage)
        val sum = Storage.sum_color

        result.append(sum.toString())
        result.append("/10")

        progres.setProgress(sum * (100 / 10))
    }
}