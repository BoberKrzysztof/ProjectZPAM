package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Activity_CISS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__c_i_s_s)

        val next = findViewById<Button>(R.id.CISS_next)
        val answ1 = findViewById<RadioButton>(R.id.CISS1)
        val answ2 = findViewById<RadioButton>(R.id.CISS2)
        val answ3 = findViewById<RadioButton>(R.id.CISS3)
        val answ4 = findViewById<RadioButton>(R.id.CISS4)
        val answ5 = findViewById<RadioButton>(R.id.CISS5)
        val question = findViewById<TextView>(R.id.question)

        val question_list = arrayOf(
            "1. I am better organized in stressful situations",
            "2. I can manage my time better in a stressful situation",
            "3. In a stressful situation, I like to be alone",
            "4. In a stressful situation, I prefer to be among people",
            "5. In stressful situations, I often explode with anger",
            "6. I can focus in a stressful situation",
            "7. In a stressful situation, I shut myself off",
            "8. In a stressful situation, I blame myself for failures",
            "9. In a stressful situation, I think of the better old days",
            "10. Maintains a sober mind in stressful situations",
            "11. I can make decisions in stressful situations",
            "12. I eat more than usual in stressful situations",
            "13. In a stressful situation, I can't sleep",
            "14. In a stressful situation, I have health problems",
            "15. In a stressful situation, I don't worry about",
            "16. In a stressful situation, I avoid difficult topics",
            "17. In a stressful situation, I reach out to friends for advice",
            "18. I get depressed in stressful situations"
        )
        val answers_list = ArrayList<String>()

        var radio_group = findViewById<RadioGroup>(R.id.radioGroup)

        var i = 0


        next.setOnClickListener{

            if (i == question_list.size-1){
                next.setText("Send")
            }

            if (answ1.isChecked){
                answers_list.add(question_list[i] + "\n" + answ1.text)
                i++
                question.setText(question_list[i])
            }
            else if (answ2.isChecked){
                answers_list.add(question_list[i] + "\n" + answ2.text)
                i++
                question.setText(question_list[i])
            }
            else if (answ3.isChecked){
                answers_list.add(question_list[i] + "\n" + answ3.text)
                i++
                question.setText(question_list[i])
            }
            else if (answ4.isChecked){
                answers_list.add(question_list[i] + "\n" + answ4.text)
                i++
                question.setText(question_list[i])
            }
            else if (answ5.isChecked){
                answers_list.add(question_list[i] + "\n" + answ5.text)
                i++
                question.setText(question_list[i])
            }
            else{
                Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
            }
            radio_group.clearCheck()


            if (i == question_list.size-1){
                next.setOnClickListener {
                    val intent = Intent(this, activity_tests_page::class.java)
                    startActivity(intent)
                }
            }
            }
        }
    }
