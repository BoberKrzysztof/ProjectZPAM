package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // items which can be find on activity_registration screen
        val backImage = findViewById<ImageView>(R.id.backImage)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val firstNameEdit = findViewById<EditText>(R.id.firstNameEdit)
        val surnameEdit = findViewById<EditText>(R.id.surnameEdit)
        val loginEdit = findViewById<EditText>(R.id.loginEdit)
        val passEdit = findViewById<EditText>(R.id.passEdit)
        val rPassEdit = findViewById<EditText>(R.id.rPassEdit)
        val femaleCheckBox = findViewById<CheckBox>(R.id.femaleCheckBox)
        val maleCheckBox = findViewById<CheckBox>(R.id.maleCheckBox)

        // methods
        //comparePass(registerButton, passEdit, rPassEdit)
        backToLogin(backImage)
        chooseSex(maleCheckBox, femaleCheckBox)
        /*isAllFilledUp(
            firstNameEdit,
            surnameEdit,
            loginEdit,
            passEdit,
            rPassEdit,
            registerButton,
            femaleCheckBox,
            maleCheckBox
        )*/
    }

    private fun isAllFilledUp(
        name: EditText,
        surname: EditText,
        login: EditText,
        pass: EditText,
        rPass: EditText,
        button: Button,
        c1: CheckBox,
        c2: CheckBox
    ) {
        val str1 = name.text.toString()
        val str2 = surname.text.toString()
        val str3 = login.text.toString()
        val str4 = pass.text.toString()
        val str5 = rPass.text.toString()
        button.setOnClickListener {
            if (str1.isEmpty()) {
                c1.isChecked = true
            }
            else {
                c2.isChecked = false
            }
        }
    }


    private fun chooseSex(c1: CheckBox, c2: CheckBox) {
        c1.setOnClickListener {
            c1.isChecked = true
            c2.isChecked = false
        }
        c2.setOnClickListener {
            c1.isChecked = false
            c2.isChecked = true
        }
    }

    private fun comparePass(button: Button, pass: EditText, rPass: EditText) {
        button.setOnClickListener {
            val str1 = pass.text.toString()
            val str2 = rPass.text.toString()
            if (str1 == str2) {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun backToLogin(back: ImageView) {
        back.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

}