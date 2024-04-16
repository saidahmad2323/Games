package com.example.mywork.Room

import androidx.lifecycle.LiveData

class RoomRepository(private val dao: Dao): Repository {
    override val readAllTodo: LiveData<List<Todo>>
        get() = dao.getAllTodo()

    override suspend fun create(todo: Todo, createData: String, onSucces: () -> Unit) {
        val noteWithData = todo.copy(createData = createData)
        dao.createData(todo)
        onSucces()
    }

    override suspend fun delete(todo: Todo, onSucces: () -> Unit) {
        dao.delete(todo)
        onSucces()
    }

    override suspend fun update(todo: Todo, createData: String, onSucces: () -> Unit) {
        val noteWithData = todo.copy(createData = createData)
        dao.update(todo)
        onSucces()
    }

}

lateinit var REPOSITORY: RoomRepository