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

        val startButton = findViewById<Button>(R.id.start_button)
        val red = findViewById<Button>(R.id.red_button)
        val green = findViewById<Button>(R.id.green_button)
        green.setVisibility(View.GONE)
        val best_result = findViewById<TextView>(R.id.best_result)
        val average_result = findViewById<TextView>(R.id.average_result)
        val time = findViewById<Chronometer>(R.id.time_reaction_test)
        time.setVisibility(View.GONE)
        val time_text = findViewById<TextView>(R.id.text_time)
        var i = 0
        var result_list = arrayOf<String>()

        fun start() {
            startButton.setOnClickListener {
                i++
                val delay = (1000..3000).random()
                SystemClock.sleep(delay.toLong())
                time.setBase(SystemClock.elapsedRealtime())
                time.start()
                red.setVisibility(View.GONE)
                green.setVisibility(View.VISIBLE)
                green.setOnClickListener {
                    time.stop()
                    val milisec = (SystemClock.elapsedRealtime() - time.getBase()).toString()
                    time_text.setText(milisec)
                    time_text.append(" milliseconds")
                    green.setVisibility(View.GONE)
                    red.setVisibility(View.VISIBLE)

                    result_list += (milisec)

                    var largest = result_list[0]
                    for (ms in result_list) {
                        if (largest.toInt() < ms.toInt()) {
                            largest = ms
                        }
                    }

                    best_result.setText(largest)
                    best_result.append(" milliseconds")
                    Storage.reaction_best_result_storage = largest.toInt()

                    var average = 0
                    for (ms in result_list) average += ms.toInt()
                    average = average / result_list.size


                    average_result.setText(average.toString())
                    average_result.append(" milliseconds")
                    Storage.reaction_average_result_storage = average
                }
            }
        }

        if (i < 4) {
            start()
        } else {
            startButton.setText("Return")
            startButton.setOnClickListener{
                val intent = Intent(this, activity_tests_page::class.java)
                startActivity(intent)
            }
        }

        /*val result = milisec[7].toString() + milisec[8].toString() + milisec[9].toString()
        result_list += (result)

        var largest = result_list[0]
        for (ms in result_list) {
            if (largest.toInt() < ms.toInt()) {
                largest = ms
            }
        }

        best_result.setText(largest)
        best_result.append(" milliseconds")

        var average: Double = 0.0
        for (ms in result_list) average += ms.toDouble()
        average = average / result_list.size

        average_result.setText(average.toString())
        average_result.append(" milliseconds")*/
    }
}
