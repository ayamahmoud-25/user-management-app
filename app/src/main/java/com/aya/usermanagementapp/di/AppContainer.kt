package com.aya.usermanagementapp.di

import android.content.Context
import com.aya.usermanagementapp.data.local.database.AppDatabase
import com.aya.usermanagementapp.data.repository.UserRepository

class AppContainer(context: Context) {

    private val database = AppDatabase.getDatabase(context)

    private val userDao = database.userDao()

    val repository = UserRepository(userDao)
}