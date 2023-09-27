package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    var list = mutableListOf<Todo>()
    private val getContext = TodoAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        getContext.context = this

        val buttonBack = findViewById<Button>(R.id.butBack)

//        val name = intent.getStringExtra("ExteraName")                                         //**extra**//
//        val lastName = intent.getStringExtra("ExteraLasetName")
//        val age = intent.getIntExtra("ExteraAge", 0)
//        val strFinally =
//            "your name is $name and your last name is $lastName and you are $age years old."  //**extra**//

        val person: Person =
            intent.getSerializableExtra("Extra_person") as Person                     //**data class**//
//        binding.txview.text = "${person.name.toString()}"

        buttonBack.setOnClickListener {
//            finish()
            onBackPressedDispatcher.onBackPressed()
        }                                                                                     //**data class**//


        var todoList = mutableListOf(
            Todo("to do_1", false),
            Todo("to do_2", true),
            Todo("to do_3", false),
            Todo("to do_4", false)

        )

        val adapter = TodoAdapter(todoList)
//        val a: OnClickListenerTodo = object : OnClickListenerTodo {
//            override fun onClick(todo: Todo) {
//                val intent = Intent(this@ActivitySecond, ActivityThird::class.java)
//                intent.putExtra("todo", todo)
//                startActivity(intent)
//            }
//
//        }


        binding.recycleView.adapter = adapter
//        binding.recycleView.layoutManager = LinearLayoutManager(this)

        adapter.setOnClick(object : OnClickListenerTodo {
            override fun onClick(todo: Todo) {
                val intent = Intent(this@ActivitySecond, ActivityThird::class.java)
                intent.putExtra("todo", todo)
//        intent.putExtra("check",tog.isChecked)
                startActivity(intent)
            }

        })
        binding.butAdd.setOnClickListener {
            val title = binding.editText.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
//            adapter.notifyDataSetChanged()
        }


    }
}