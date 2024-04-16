package com.example.mywork.Room

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ViewModelTodo(application: Application): AndroidViewModel(application) {

    private val REPOSITORY: RoomRepository

    init {
        val dao = RoomDatabasee.getInstance(application).dao()
        REPOSITORY = RoomRepository(dao)
    }

    fun getAllTodo() = REPOSITORY.readAllTodo

    fun addTodo(title: String, subtitle: String, onSucces: () -> Unit){
        val createData = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
        val notes = Todo(title, subtitle, createData)
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(notes, createData){
                onSucces()
            }
        }
    }

//    fun update(todo: Todo, createData: String, onSucces: () -> Unit){
//        viewModelScope.launch(Dispatchers.IO){
//            REPOSITORY.update(todo, createData){
//                onSucces()
//            }
//        }
//    }

    fun delete(todo: Todo, onSucces: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.delete(todo){
                onSucces()
            }
        }
    }

}


class ViewModelFactoryTodo(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelTodo::class.java)){
            return ViewModelTodo(application) as T
        }
        throw IllegalArgumentException("notepad")
    }
}