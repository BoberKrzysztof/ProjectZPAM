package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class Activity_reaction_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_test)
        val log = intent
        val l = log.getStringExtra("LOGIN")
        val startButton = findViewById<Button>(R.id.start_button)
        val red = findViewById<Button>(R.id.red_button)
        red.setText(" ")
        val green = findViewById<Button>(R.id.green_button)
        green.visibility = View.GONE
        val best_result = findViewById<TextView>(R.id.best_result)
        val average_result = findViewById<TextView>(R.id.average_result)
        val time = findViewById<Chronometer>(R.id.time_reaction_test)
        time.visibility = View.GONE
        val time_text = findViewById<TextView>(R.id.text_time)
        var i = 0
        var result_list = arrayOf<String>()

        fun start() {
            startButton.setOnClickListener {
                i++
                red.setText("Wait")
                val delay = (1000..3000).random()
                SystemClock.sleep(delay.toLong())
                time.base = SystemClock.elapsedRealtime()
                time.start()
                red.visibility = View.GONE
                green.visibility = View.VISIBLE
                green.setOnClickListener {
                    time.stop()
                    val milisec = (SystemClock.elapsedRealtime() - time.base).toString()
                    time_text.text = milisec
                    time_text.append(" ms")
                    red.setText(" ")
                    green.visibility = View.GONE
                    red.visibility = View.VISIBLE

                    result_list += (milisec)

                    var lowest = result_list[0]
                    for (ms in result_list) {
                        if (lowest.toInt() > ms.toInt()) {
                            lowest = ms
                        }
                    }
                    best_result.text = "Best: $lowest ms"

                    var average = 0
                    for (ms in result_list) average += ms.toInt()
                    average /= result_list.size
                    average_result.text = "Average: $average ms"

                    if (i == 1) {
                        Toast.makeText(this, "${3 - i} trials left", Toast.LENGTH_SHORT).show()
                    }

                    if (i == 2) {
                        Toast.makeText(this, "${3 - i} trial left", Toast.LENGTH_SHORT).show()
                    }

                    if (i == 3) {
                        Storage.reaction_best_result_storage = lowest.toInt()
                        Storage.reaction_average_result_storage = average
                        val updateBest = DataBaseHelper(this).updateDataBestReaction(l.toString())
                        val updateAverage = DataBaseHelper(this).updateDataAverageReaction(l.toString())
                        if (updateBest && updateAverage) {
                            val intent = Intent(this, activity_tests_page::class.java)
                            intent.putExtra("LOGIN", l)
                            startActivity(intent)
                        }
                    }

                }
            }
        }

        start()
    }
}
