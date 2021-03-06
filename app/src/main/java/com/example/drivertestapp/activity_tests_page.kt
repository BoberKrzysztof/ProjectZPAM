package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class activity_tests_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests_page)
        nextActivityColor()
        nextActivityIntelligent()
        nextActivityCISS()
        nextActivityReaction()

        logOut()

        inteligenceResult()
        CISSResult()
        ColorResult()
        ReactionResult()
    }

    private fun logOut() {
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun nextActivityColor() {
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val dataBaseHelper = DataBaseHelper(this).checkColor(l.toString()).toInt()
        val startButton = findViewById<Button>(R.id.Color_perception_button)
        startButton.setOnClickListener {
            if (dataBaseHelper != -1) {
                Toast.makeText(this, "You've already passed the test", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Activity_color_test::class.java)
                intent.putExtra("LOGIN", l)
                startActivity(intent)
                Storage.color_attempt = false
            }
        }
    }

    private fun nextActivityReaction() {
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val dataBaseHelper = DataBaseHelper(this).checkBestReaction(l.toString()).toInt()
        val startButton = findViewById<Button>(R.id.Reaction_test_button)
        startButton.setOnClickListener {
            if (dataBaseHelper != 0) {
                Toast.makeText(this, "You've already passed the test", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Activity_reaction_test::class.java)
                intent.putExtra("LOGIN", l)
                startActivity(intent)
                Storage.reaction_attempt = false
            }
        }
    }

    private fun nextActivityIntelligent() {
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val dataBaseHelper = DataBaseHelper(this).checkIntelligence(l.toString()).toInt()
        val startButton = findViewById<Button>(R.id.Inteligence_test_button)
        startButton.setOnClickListener {
            if (dataBaseHelper != -1) {
                Toast.makeText(this, "You've already passed the test", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Activity_intelligent_test::class.java)
                intent.putExtra("LOGIN", l)
                startActivity(intent)
                Storage.inteligence_attempt = false
            }
        }
    }

    private fun nextActivityCISS() {
        val startButton = findViewById<Button>(R.id.CISS_test_button)
        startButton.setOnClickListener {
            if (!Storage.CISS_attempt) {
                Toast.makeText(this, "You've already passed the test", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Activity_CISS::class.java)
                startActivity(intent)
                Storage.CISS_attempt = false
            }
        }
    }

    private fun inteligenceResult() {
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val db = DataBaseHelper(this).checkIntelligence(l.toString())
        val result = findViewById<TextView>(R.id.inteligence_result)
        val progres = findViewById<ProgressBar>(R.id.progressBar_inteligence_testPage)

        if (db.toInt() != -1){
            result.text = "Result: $db/30"
            val value = db.toInt() * (120 / 30)
            progres.progress = value
        } else {
            result.text = "Result:"
            progres.progress = 0
        }
    }

    private fun CISSResult() {

    }

    private fun ColorResult() {
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val db = DataBaseHelper(this).checkColor(l.toString())
        val result = findViewById<TextView>(R.id.result_color_testpage)
        val progres = findViewById<ProgressBar>(R.id.progressBar_color_testpage)

        if (db.toInt() != -1) {
            result.text = "Result: $db/10"
            val value = db.toInt() * 10
            progres.progress = value
        } else {
            result.text = "Result:"
            progres.progress = 0
        }

    }

    private fun ReactionResult(){
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val db1 = DataBaseHelper(this).checkBestReaction(l.toString())
        val db2 = DataBaseHelper(this).checkAverageReaction(l.toString())
        val best_result = findViewById<TextView>(R.id.reaction_result_best_testpage)
        val average_result = findViewById<TextView>(R.id.reaction_result_average_testpage)

        best_result.text = "Best: $db1 ms"
        average_result.text = "Average: $db2 ms"
    }
}