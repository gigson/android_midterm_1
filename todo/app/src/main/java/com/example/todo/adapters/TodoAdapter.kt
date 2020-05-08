package com.example.todo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.api.dto.UserTodo
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoAdapter(private var todos: List<UserTodo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var userTodo: UserTodo

        fun bind(userTodo: UserTodo) {
            this.userTodo = userTodo

            itemView.titleTextView.text = userTodo.title
            itemView.completedView.text = "Completed: " + userTodo.completed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(v)
    }

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    fun updateTodos(todos: List<UserTodo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

}