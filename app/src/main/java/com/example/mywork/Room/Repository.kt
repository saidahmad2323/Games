package com.example.mywork.Room

import androidx.lifecycle.LiveData

interface Repository {

    val readAllTodo: LiveData<List<Todo>>

    suspend fun create(todo: Todo, createData: String, onSucces: () -> Unit)

    suspend fun delete(todo: Todo, onSucces: () -> Unit)

    suspend fun update(todo: Todo, createData: String, onSucces: () -> Unit)
}