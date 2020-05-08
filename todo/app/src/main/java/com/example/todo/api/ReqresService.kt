package com.example.todo.api

import com.example.todo.api.dto.User
import com.example.todo.api.dto.UserTodo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReqresService {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{userId}/todos")
    fun getUserTodos(@Path("userId") userId: Long): Call<List<UserTodo>>

}