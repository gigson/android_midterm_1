package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.adapters.TodoAdapter
import com.example.todo.api.RetrofitClient
import com.example.todo.api.dto.UserTodo
import kotlinx.android.synthetic.main.activity_todo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val userId = intent.extras?.getLong("USER_ID")

        this.initRecycler()
        this.getAllTodos(userId!!)
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        todoList.layoutManager = layoutManager
        todoAdapter = TodoAdapter(ArrayList())
        todoList.adapter = todoAdapter
    }

    private fun getAllTodos(userId: Long) {
        RetrofitClient.reqResApi.getUserTodos(userId)
            .enqueue(object : Callback<List<UserTodo>> {

                override fun onFailure(call: Call<List<UserTodo>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<UserTodo>>,
                    response: Response<List<UserTodo>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        todoAdapter.updateTodos(response.body()!!)

                    }
                }

            })
    }

}
