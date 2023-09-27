package com.example.test

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.test.databinding.ActivityThirdBinding

class ActivityThird : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val textView = findViewById<TextView>(R.id.textview)
//        val title = intent.getStringExtra("title")
////        val check = intent.getStringExtra("check")
//        textView.text = "$title"
        val todo :Todo = intent.getSerializableExtra("todo") as Todo
        binding.textview.text = todo.title

        if (todo.isChecked){
            binding.root.setBackgroundColor(Color.MAGENTA)
        }
    }
}