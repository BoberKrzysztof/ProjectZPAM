package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*

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
        registerButton.setOnClickListener {
            addUser(
                firstNameEdit,
                surnameEdit,
                loginEdit,
                passEdit,
                rPassEdit,
                femaleCheckBox,
                maleCheckBox
            )
        }
        backToLogin(backImage)
        chooseSex(maleCheckBox, femaleCheckBox)
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

    private fun addUser(
        name: EditText,
        surname: EditText,
        login: EditText,
        password: EditText,
        rPassword: EditText,
        c1: CheckBox,
        c2: CheckBox
    ) {
        val nam = name.text.toString()
        val sur = surname.text.toString()
        val log = login.text.toString()
        val pas = password.text.toString()
        val rPas = rPassword.text.toString()
        val dataBaseHelper = DataBaseHelper(this)

        if (nam.isEmpty() || sur.isEmpty() || log.isEmpty() || pas.isEmpty() || rPas.isEmpty() || (!c1.isChecked && !c2.isChecked)) {
            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()
        } else if (pas.length < 6) {
            Toast.makeText(this, "Password should contain minimum 6 signs", Toast.LENGTH_SHORT).show()
        } else {
            if (pas == rPas) {
                val checkLogin = dataBaseHelper.checkLogin(log)
                if (checkLogin) {
                    val user = Users(name = nam, surname = sur, login = log, password = pas)
                    val insert = DataBaseHelper(applicationContext).insertUser(user)
                    if (insert) {
                        Toast.makeText(this, "Registered succesfully", Toast.LENGTH_SHORT).show()
                        name.text.clear()
                        surname.text.clear()
                        login.text.clear()
                        password.text.clear()
                        rPassword.text.clear()
                        c1.isChecked = false
                        c2.isChecked = false
                    }
                } else {
                    Toast.makeText(this, "Login exists", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Check password", Toast.LENGTH_SHORT).show()
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