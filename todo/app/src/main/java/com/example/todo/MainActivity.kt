package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.adapters.UserAdapter
import com.example.todo.api.RetrofitClient
import com.example.todo.api.dto.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initRecycler();
        this.getAllUsers()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        userList.layoutManager = layoutManager
        userAdapter = UserAdapter(ArrayList())
        userList.adapter = userAdapter
    }

    private fun getAllUsers() {
        RetrofitClient.reqResApi.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    userAdapter.updateUsers(response.body()!!)
                }
            }

        })
    }

}
