package com.example.todo.api.dto

data class User(

    val id: Long,

    val name: String,

    val email: String

)

data class UserTodo(

    val user: User,

    val id: Long,

    val title: String,

    val completed: Boolean

)