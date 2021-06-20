package com.example.drivertestapp

import android.animation.ObjectAnimator
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
            R.drawable.test5,
            R.drawable.test6,
            R.drawable.test7,
            R.drawable.test8,
            R.drawable.test9
        )
        val answers_upper_line = arrayOf(
            R.drawable.test1_odp1,
            R.drawable.test2_odp1,
            R.drawable.test3_odp1,
            R.drawable.test4_odp1,
            R.drawable.test5_odp1,
            R.drawable.test6_odp1,
            R.drawable.test7_odp1,
            R.drawable.test8_odp1,
            R.drawable.test9_odp1
        )
        val answers_lower_line = arrayOf(
            R.drawable.test1_odp2,
            R.drawable.test2_odp2,
            R.drawable.test3_odp2,
            R.drawable.test4_odp2,
            R.drawable.test5_odp2,
            R.drawable.test6_odp2,
            R.drawable.test7_odp2,
            R.drawable.test8_odp2,
            R.drawable.test9_odp2
        )
        val list_answers = arrayOf(2, 4, 3, 6, 5, 4, 4, 3, 1)
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
        val progress_procent = findViewById<ProgressBar>(R.id.progressbar_inteligence)

        val radio_group_up = findViewById<RadioGroup>(R.id.RadioGroupUp)
        val radio_group_low = findViewById<RadioGroup>(R.id.RadioGroupLow)
        val radio_group = findViewById<RadioGroup>(R.id.radioGrourMain)

        val chronometr = findViewById<Chronometer>(R.id.Chronometer)



        fun press_next_button() {
            var i = 0
            var answer: Int
            var sum = 0
            next.setOnClickListener {

                fun change_image(){
                    i++
                    progress_procent.incrementProgressBy(100/questions.size)
                    procent_text.setText(progress_procent.progress.toString())
                    procent_text.append("/100%")
                    question_images.setImageResource(questions[i])
                    answer_upper_image.setImageResource(answers_upper_line[i])
                    answer_lower_image.setImageResource(answers_lower_line[i])
                    radio_group_low.clearCheck()
                    radio_group_up.clearCheck()
                }

                if (i == 0){
                    chronometr.start()
                }

                if (i == questions.size-2){
                    chronometr.stop()
                    //Toast.makeText(this, "Your result: $sum/" + questions.size , Toast.LENGTH_SHORT).show()
                    next.setText("Finish")
                }

                if (i == questions.size-1){
                    val window = PopupWindow(this)
                    val view = layoutInflater.inflate(R.layout.popup_inteligence,null)
                    window.contentView = view
                    val time = findViewById<TextView>(R.id.final_time)
                    time.setText(chronometr.base.toString())
                    val result = findViewById<TextView>(R.id.final_result)
                    result.append("Your result: ")
                    result.append(sum.toString())
                    result.append("/")
                    result.append(questions.size.toString())
                    val submit = findViewById<Button>(R.id.submit_button)
                    submit.setOnClickListener {
                        window.dismiss()
                    }
                    window.animationStyle
                }

                if (i < questions.size-1) {
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
                    } else {
                        Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }

        //sposób na wygaszenia jakiegość wiersza. próbowałem kilka sposobów ale nie udało mi tego rozwiązać
        //próbowałem zmiane radiogroup na layout, a wszystko zrobić w jednym RadioGroup nie można ponieważ, RadioGroup można ustawić tylko w pozycji wertykalnej czy horyzontalnej
        //nie wiem jak zrobić tak żeby ono w czasie rzeczywistym sprawdzało naciśnięcie jakiegoś radiobuttona
        if (answ1.isChecked or answ2.isChecked or answ3.isChecked) {
            radio_group_low.clearCheck()
            }
        if(answ4.isChecked or answ5.isChecked or answ6.isChecked) {
            radio_group_up.clearCheck()
        }
        press_next_button()


    }
}