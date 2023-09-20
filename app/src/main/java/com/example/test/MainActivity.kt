package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<ConstraintLayout>(R.id.ac_main_root)
        val rg = findViewById<RadioGroup>(R.id.radioG)         //* //radioButton and checkBox
        val button = findViewById<Button>(R.id.button)
        val checkDark = findViewById<CheckBox>(R.id.check1)
        val checkLight = findViewById<CheckBox>(R.id.check2)
        val checkColorfull = findViewById<CheckBox>(R.id.check3)
        val textView = findViewById<TextView>(R.id.textview)

        button.setOnClickListener {

            val radioG = rg.checkedRadioButtonId             //*
            val color = findViewById<RadioButton>(radioG)   //*
            val dark = checkDark.isChecked
            val light = checkLight.isChecked
            val colorfull = checkColorfull.isChecked

            val strFinally = "you selected:\n" + "${color.text}" + "\n" +
                    (if (dark) "dark\n" else "") +
                    (if (light) "light\n" else "") +
                    (if (colorfull) "colorfull\n" else "")

            textView.text = strFinally         //radioButton and checkBox

            ////////////////////////////////////////////////////////////////////

            val nextButton = findViewById<Button>(R.id.next) //nextactivity

            nextButton.setOnClickListener {
                // Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show()  //first
                //  Toast.makeText(applicationContext, "hello world", Toast.LENGTH_LONG).show()  //second

                Intent(this,ActivitySecond::class.java).also {
                    startActivity(it)
                }
            }

        }

    }


}
