package com.example.test

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val buttonBack=findViewById<Button>(R.id.butBack)
        buttonBack.setOnClickListener {
            finish()
        }
        }
}