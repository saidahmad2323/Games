package com.example.mywork.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Query("SELECT * FROM table_name")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo: Todo)

    @Insert
    suspend fun createData(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}