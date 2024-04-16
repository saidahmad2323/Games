package com.example.mywork.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mywork.Object.Screens
import com.example.mywork.Room.Todo
import com.example.mywork.Room.ViewModelTodo

@Composable
fun ListScreen(
    navController: NavController,
    viewModelTodo: ViewModelTodo
) {
    val todos = viewModelTodo.getAllTodo().observeAsState(listOf()).value
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(todos){ items ->
            Column(
                modifier = Modifier.clickable{
                    viewModelTodo.delete(
                        Todo(title = items.title,
                            subtitle = items.subtitle,
                            createData = items.createData, id = items.id)
                    ){

                    }
                }
            ) {
                Text(text = items.title)
                Text(text = items.subtitle)
                Text(text = items.createData)
            }
        }
    }
    Button(onClick = { navController.navigate(Screens.AddScreen.route) }) {
        Text(text = "dob")
    }
}
