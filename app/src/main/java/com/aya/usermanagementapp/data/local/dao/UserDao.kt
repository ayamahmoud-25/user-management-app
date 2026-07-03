package com.aya.usermanagementapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aya.usermanagementapp.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)


    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>


    @Delete
    suspend fun deleteUser(user: UserEntity)


    @Update
    suspend fun updateUser(user: UserEntity)

}


