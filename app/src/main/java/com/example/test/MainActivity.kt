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
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding    //binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        }
        ////////////////////////////////////////////////////////////////////

//        val nextButton = findViewById<Button>(R.id.next) //nextactivity
//        nextButton.setOnClickListener {
//            // Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show()  //Toast_1
//            //  Toast.makeText(applicationContext, "hello world", Toast.LENGTH_LONG).show()  //Toast_2
//
//            Intent(this, ActivitySecond::class.java).also { //next activity
//                startActivity(it)
//            }
//        }

        binding.butApply.setOnClickListener {

            val name = binding.edittext1.text.toString()
            val lastName = binding.edittext2.text.toString()
            val age = binding.edittext3.text.toString().toInt()

            val person = Person(name, lastName, age)

            Intent(this, ActivitySecond::class.java).also {

//                it.putExtra("ExteraName", name)
//                it.putExtra("ExteraLasetName", lastName)
//                it.putExtra("ExterAge", age)

                it.putExtra("Extra_person",person)

                startActivity(it)
            }

        }

    }

}



