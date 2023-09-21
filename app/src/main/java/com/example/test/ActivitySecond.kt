package com.example.test

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack = findViewById<Button>(R.id.butBack)

//        val name = intent.getStringExtra("ExteraName")
//        val lastName = intent.getStringExtra("ExteraLasetName")
//        val age = intent.getIntExtra("ExteraAge", 0)
//        val strFinally =
//            "your name is $name and your last name is $lastName and you are $age years old."

        val person: Person =intent.getSerializableExtra("Extra_person") as Person
        binding.txview.text = "${person.name.toString()}"

        buttonBack.setOnClickListener {
//            finish()
            onBackPressedDispatcher.onBackPressed()
        }
    }
}