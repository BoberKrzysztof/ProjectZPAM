package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.os.SystemClock.elapsedRealtime
import android.widget.*
import kotlin.math.ceil
import kotlin.math.roundToInt


class Activity_inteligence_test2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inteligence_test2)

        val questions = arrayOf(
            R.drawable.test10,
            R.drawable.test11,
            R.drawable.test12,
            R.drawable.test13,
            R.drawable.test14,
            R.drawable.test15,
            R.drawable.test16,
            R.drawable.test17,
            R.drawable.test18,
            R.drawable.test19,
            R.drawable.test20,
            R.drawable.test21,
            R.drawable.test22,
            R.drawable.test23,
            R.drawable.test24,
            R.drawable.test25,
            R.drawable.test26,
            R.drawable.test27,
            R.drawable.test28,
            R.drawable.test29,
            R.drawable.test30
        )
        val answers_upper_line = arrayOf(
            R.drawable.test10_odp1,
            R.drawable.test11_odp1,
            R.drawable.test12_odp1,
            R.drawable.test13_odp1,
            R.drawable.test14_odp1,
            R.drawable.test15_odp1,
            R.drawable.test16_odp1,
            R.drawable.test17_odp1,
            R.drawable.test18_odp1,
            R.drawable.test19_odp1,
            R.drawable.test20_odp1,
            R.drawable.test21_odp1,
            R.drawable.test22_odp1,
            R.drawable.test23_odp1,
            R.drawable.test24_odp1,
            R.drawable.test25_odp1,
            R.drawable.test26_odp1,
            R.drawable.test27_odp1,
            R.drawable.test28_odp1,
            R.drawable.test29_odp1,
            R.drawable.test30_odp1
        )
        val answers_lower_line = arrayOf(
            R.drawable.test10_odp2,
            R.drawable.test11_odp2,
            R.drawable.test12_odp2,
            R.drawable.test13_odp2,
            R.drawable.test14_odp2,
            R.drawable.test15_odp2,
            R.drawable.test16_odp2,
            R.drawable.test17_odp2,
            R.drawable.test18_odp2,
            R.drawable.test19_odp2,
            R.drawable.test20_odp2,
            R.drawable.test21_odp2,
            R.drawable.test22_odp2,
            R.drawable.test23_odp2,
            R.drawable.test24_odp2,
            R.drawable.test25_odp2,
            R.drawable.test26_odp2,
            R.drawable.test27_odp2,
            R.drawable.test28_odp2,
            R.drawable.test29_odp2,
            R.drawable.test30_odp2
        )
        val list_answers = arrayOf(8, 8, 5, 8, 7, 5, 5, 6, 3, 4, 4, 3, 7, 6, 4, 5, 8, 1, 6, 7, 6)
        val answ1 = findViewById<RadioButton>(R.id.answer1_1)
        val answ2 = findViewById<RadioButton>(R.id.answer2_1)
        val answ3 = findViewById<RadioButton>(R.id.answer3_1)
        val answ4 = findViewById<RadioButton>(R.id.answer4_1)
        val answ5 = findViewById<RadioButton>(R.id.answer5_1)
        val answ6 = findViewById<RadioButton>(R.id.answer6_1)
        val answ7 = findViewById<RadioButton>(R.id.answer7_1)
        val answ8 = findViewById<RadioButton>(R.id.answer8_1)

        val question_images = findViewById<ImageView>(R.id.question_image2)
        val answer_upper_image = findViewById<ImageView>(R.id.answer_upper_image2)
        val answer_lower_image = findViewById<ImageView>(R.id.answer_lower_image2)

        val next = findViewById<Button>(R.id.next_button2)
        val procent_text = findViewById<TextView>(R.id.procent_text2)
        val progress_procent = findViewById<ProgressBar>(R.id.progressbar_inteligence2)
        progress_procent.setProgress(8 * (120 / 30))
        procent_text.setText(progress_procent.progress.toString())
        procent_text.append("/100%")

        val radio_group_up = findViewById<RadioGroup>(R.id.radio_group_up2)
        val radio_group_low = findViewById<RadioGroup>(R.id.radio_group_low2)
        val radio_group = findViewById<RadioGroup>(R.id.radioGrourMain2)


        fun press_next_button() {
            var i = 0
            var answer: Int
            var sum = Storage.sum
            next.setOnClickListener {

                fun change_image() {
                    i++
                    val incriment = (120/30)
                    progress_procent.incrementProgressBy(incriment)
                    procent_text.setText((progress_procent.progress/1.2).toInt().toString())
                    procent_text.append("/100%")
                    question_images.setImageResource(questions[i])
                    answer_upper_image.setImageResource(answers_upper_line[i])
                    answer_lower_image.setImageResource(answers_lower_line[i])
                    radio_group_low.clearCheck()
                    radio_group_up.clearCheck()
                }

                if (i == questions.size - 2) {
                    //Toast.makeText(this, "Your result: $sum/" + questions.size , Toast.LENGTH_SHORT).show()
                    next.setText("Finish")

                }
                if (i < questions.size - 1) {
                    if (answ1.isChecked) {
                        answer = 1
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ2.isChecked) {
                        answer = 2
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ3.isChecked) {
                        answer = 3
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ4.isChecked) {
                        answer = 4
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ5.isChecked) {
                        answer = 5
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ6.isChecked) {
                        answer = 6
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ7.isChecked) {
                        answer = 7
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else if (answ8.isChecked) {
                        answer = 8
                        if (answer == list_answers[i]) {
                            sum++
                        }
                        change_image()
                    } else {
                        Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
                    }

                    if (i == questions.size - 1) {
                        next.setOnClickListener {
                            answer = 6
                            if (answer == list_answers[i]){
                                sum++
                            }

                            Storage.sum2 = sum
                            val intent = Intent(this, activity_tests_page::class.java)
                            startActivity(intent)
                        }
                    }
                }

            }
        }

        fun check_radiobutton() {
            answ1.setOnClickListener {
                if (answ5.isChecked or answ6.isChecked or answ7.isChecked or answ8.isChecked) {
                    radio_group_low.clearCheck()
                }
            }
            answ2.setOnClickListener {
                if (answ5.isChecked or answ6.isChecked or answ7.isChecked or answ8.isChecked) {
                    radio_group_low.clearCheck()
                }
            }
            answ3.setOnClickListener {
                if (answ5.isChecked or answ6.isChecked or answ7.isChecked or answ8.isChecked) {
                    radio_group_low.clearCheck()
                }
            }
            answ4.setOnClickListener {
                if (answ5.isChecked or answ6.isChecked or answ7.isChecked or answ8.isChecked) {
                    radio_group_low.clearCheck()
                }
            }
            answ5.setOnClickListener {
                if (answ1.isChecked or answ2.isChecked or answ3.isChecked or answ4.isChecked) {
                    radio_group_up.clearCheck()
                }
            }
            answ6.setOnClickListener {
                if (answ1.isChecked or answ2.isChecked or answ3.isChecked or answ4.isChecked) {
                    radio_group_up.clearCheck()
                }
            }
            answ7.setOnClickListener {
                if (answ1.isChecked or answ2.isChecked or answ3.isChecked or answ4.isChecked) {
                    radio_group_up.clearCheck()
                }
            }
            answ8.setOnClickListener {
                if (answ1.isChecked or answ2.isChecked or answ3.isChecked or answ4.isChecked) {
                    radio_group_up.clearCheck()
                }
            }
        }

        check_radiobutton()
        press_next_button()

    }
}
