package com.example.drivertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class Activity_color_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_test)
        val button = findViewById<Button>(R.id.button5)
        val imageView = findViewById<ImageView>(R.id.imageView3)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val images = arrayOf(
            R.drawable.color4,
            R.drawable.color29,
            R.drawable.color3a,
            R.drawable.color12,
            R.drawable.color7,
            R.drawable.color2,
            R.drawable.color6,
            R.drawable.color15,
            R.drawable.color3b,
            R.drawable.color5
        )
        val values = arrayOf(4, 29, 3, 12, 7, 2, 6, 15, 3, 5)
        var sum = 0
        var i = 0
        imageView.setImageResource(images[i])
        val log = intent
        val l = log.getStringExtra("LOGIN")

        button.setOnClickListener {
            if (editText.text.toString() == "") {
                Toast.makeText(this, "A number must be entered", Toast.LENGTH_SHORT).show()
            } else {
                if (editText.text.toString().toInt() == values[i]) {
                    sum += 1
                }
                if (i == images.size - 1) {
                    Storage.sum_color = sum
                    val updateColor = DataBaseHelper(this).updateDataColor(l.toString())
                    if (updateColor) {
                        val intent = Intent(this, activity_tests_page::class.java)
                        intent.putExtra("LOGIN", l)
                        startActivity(intent)
                    }
                } else {
                    i++
                }
                imageView.setImageResource(images[i])
                editText.setText("")
            }
        }

    }
}