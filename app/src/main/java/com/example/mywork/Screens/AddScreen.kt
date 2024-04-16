package com.example.mywork.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mywork.Object.Screens
import com.example.mywork.Room.Todo
import com.example.mywork.Room.ViewModelTodo
import kotlinx.coroutines.launch

@Composable
fun AddScreen(
    navController: NavController,
    viewModelTodo: ViewModelTodo
) {
    Column(
        modifier = Modifier.fillMaxSize()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center
    ) {
        var title by remember{ mutableStateOf("")}
        var subtitle by remember{ mutableStateOf("")}
        val coroutine = rememberCoroutineScope()
        TextField(
            value = title,
            onValueChange = {title = it})
        TextField(
            value = subtitle,
            onValueChange = {subtitle = it})

        Button(onClick = {
            viewModelTodo.addTodo(
                    title = title,
                    subtitle = subtitle
            ){
                coroutine.launch {
                    navController.navigate(Screens.ListScreen.route)
                }
            }
        }) {
            Text("Add")
        }
    }
}