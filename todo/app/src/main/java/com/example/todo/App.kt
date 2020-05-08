package com.example.todo

import android.app.Application
import com.example.todo.api.RetrofitClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }

}