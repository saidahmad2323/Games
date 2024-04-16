package com.example.mywork.Object

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywork.Room.ViewModelTodo
import com.example.mywork.Screens.AddScreen
import com.example.mywork.Screens.ListScreen
import com.example.mywork.Screens.NoteScreen

sealed class Screens(val route: String){
    object ListScreen: Screens("list_screen")
    object AddScreen: Screens("add_screen")
    object NoteScreen: Screens("note_screen")
}

@Composable
fun NavGraph(
    viewModelTodo: ViewModelTodo
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.ListScreen.route){
        composable(Screens.ListScreen.route){
            ListScreen(navController, viewModelTodo)
        }
        composable(Screens.AddScreen.route){
            AddScreen(navController, viewModelTodo)
        }
        composable(Screens.NoteScreen.route){
            NoteScreen(navController, viewModelTodo)
        }
    }
}