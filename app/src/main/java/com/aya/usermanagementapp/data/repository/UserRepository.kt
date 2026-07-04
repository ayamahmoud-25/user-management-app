package com.aya.usermanagementapp.data.repository

import com.aya.usermanagementapp.data.local.dao.UserDao
import com.aya.usermanagementapp.data.local.entity.UserEntity

class UserRepository(
    private val dao: UserDao
) {

    suspend fun insertUser(user: UserEntity) {
        dao.insertUser(user)
    }

    fun getAllUsers() = dao.getAllUsers()

    suspend fun deleteUser(user: UserEntity) {
        dao.deleteUser(user)
    }

    suspend fun updateUser(user: UserEntity) {
        dao.updateUser(user)
    }
}