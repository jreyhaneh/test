package com.example.test

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemTodoBinding
import kotlin.properties.Delegates


class TodoAdapter(
    var todo: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private lateinit var binding:ItemTodoBinding
    //    lateinit var context: Context
    private var onClickListener: OnClickListenerTodo? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context))
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        val textView = holder.itemView.findViewById<TextView>(R.id.tvTitle)

        holder.itemView.apply {
//            val textView = findViewById<TextView>(R.id.tvTitle)
//            val checkbox = findViewById<CheckBox>(R.id.chbToDo)
//            val click = findViewById<ConstraintLayout>(R.id.root)

            binding.tvTitle.text = todo[position].title
            binding.chbToDo.isChecked = todo[position].isChecked

//            click.setOnClickListener {
//                todo[position].isChecked = !checkbox.isChecked
//                detail(context)
//                notifyItemChanged(position)
//            }

            binding.root.setOnClickListener {
                if (onClickListener != null) {
                    onClickListener!!.onClick(todo[position])
                }
            }
            if (binding.chbToDo.isChecked) {
                binding.root.setBackgroundColor(Color.parseColor("#FFCC00"))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.gray))
            }

//            checkbox.setOnCheckedChangeListener { buttonView, isChecked ->   //kharab
//                todo[position].isChecked = isChecked
//                notifyItemChanged(position)
//            }
            binding.chbToDo.isClickable = false
        }


    }


    override fun getItemCount(): Int {
        return todo.size
    }

    fun setOnClick(onClickListener: OnClickListenerTodo) {
        this.onClickListener = onClickListener
//        lateinit var name: String
//        var check by Delegates.notNull<Boolean>()
//        val tog = Todo(title = name, isChecked = check)
//        val intent = Intent(context, ActivityThird::class.java)
//        intent.putExtra("title", tog.title)
////        intent.putExtra("check",tog.isChecked)

//        startActivity(context, intent, bundleOf())
    }


    inner class TodoViewHolder(itemView: ItemTodoBinding) : RecyclerView.ViewHolder(itemView.root)


}

interface OnClickListenerTodo {
    fun onClick(todo: Todo)

//    fun data(todo: Todo)

}

