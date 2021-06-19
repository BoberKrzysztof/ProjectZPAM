package com.example.drivertestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Activity_intelligent_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intelligent_test)
        val questions = arrayOf(
            R.drawable.test1,
            R.drawable.test2,
            R.drawable.test3,
            R.drawable.test4,
            R.drawable.test5
        )
        val answers_upper_line = arrayOf(
            R.drawable.test1_odp1,
            R.drawable.test2_odp1,
            R.drawable.test3_odp1,
            R.drawable.test4_odp1,
            R.drawable.test5_odp1,
        )
        val answers_lower_line = arrayOf(
            R.drawable.test1_odp2,
            R.drawable.test2_odp2,
            R.drawable.test3_odp2,
            R.drawable.test4_odp2,
            R.drawable.test5_odp2,
        )
        val list_answers = arrayOf(2, 4, 3, 6, 5)
        val answ1 = findViewById<RadioButton>(R.id.answer1)
        val answ2 = findViewById<RadioButton>(R.id.answer2)
        val answ3 = findViewById<RadioButton>(R.id.answer3)
        val answ4 = findViewById<RadioButton>(R.id.answer4)
        val answ5 = findViewById<RadioButton>(R.id.answer5)
        val answ6 = findViewById<RadioButton>(R.id.answer6)

        val question_images = findViewById<ImageView>(R.id.question_image)
        val answer_upper_image = findViewById<ImageView>(R.id.answer_upper_image)
        val answer_lower_image = findViewById<ImageView>(R.id.answer_lower_image)

        val next = findViewById<Button>(R.id.next_button)
        val procent_text = findViewById<TextView>(R.id.procent_text)
        val progress_procent = findViewById<ProgressBar>(R.id.progressbar)

        val radio_group_up = findViewById<RadioGroup>(R.id.RadioGroupUp)
        val radio_group_low = findViewById<RadioGroup>(R.id.RadioGroupLow)

        fun press_next_button() {
            var i = 0
            var answer: Int
            var sum = 0
            var present_progres: Int
            next.setOnClickListener {
                if (answ1.isChecked) {
                    answer = 1
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else if (answ2.isChecked) {
                    answer = 2
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else if (answ3.isChecked) {
                    answer = 3
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else if (answ4.isChecked) {
                    answer = 4
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else if (answ5.isChecked) {
                    answer = 5
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else if (answ6.isChecked) {
                    answer = 6
                    if (answer == list_answers[i]) {
                        sum++
                    }
                } else {
                    Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
                }
                i++
                present_progres = (i / questions.size) * 100
                procent_text.setText("$present_progres/100%")
                progress_procent.setProgress(present_progres)
                question_images.setImageResource(questions[i])
                answer_upper_image.setImageResource(answers_upper_line[i])
                answer_lower_image.setImageResource(answers_lower_line[i])
                radio_group_low.clearCheck()
                radio_group_up.clearCheck()
            }

        }

        //sposób na wygaszenia jakiegość wiersza. próbowałem kilka sposobów ale nie udało mi tego rozwiązać
        //próbowałem zmiane radiogroup na layout, a wszystko zrobić w jednym RadioGroup nie można ponieważ, RadioGroup można ustawić tylko w pozycji wertykalnej czy horyzontalnej
        //nie wiem jak zrobić tak żeby ono w czasie rzeczywistym sprawdzało naciśnięcie jakiegoś radiobuttona
        if (radio_group_up.getCheckedRadioButtonId() == -1) {
            press_next_button()
        } else {
            radio_group_low.clearCheck()
        }
        if (radio_group_low.getCheckedRadioButtonId() == -1) {
            press_next_button()
        } else {
            radio_group_up.clearCheck()

        }
    }
}