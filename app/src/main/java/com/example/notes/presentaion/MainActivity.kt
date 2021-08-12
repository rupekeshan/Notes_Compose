package com.example.notes.presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.presentaion.navigation.Screens
import com.example.notes.presentaion.screens.home.HomeScreen
import com.example.notes.presentaion.screens.notelist.NoteListScreen
import com.example.notes.presentaion.screens.notesadd.NotesAddScreen
import com.example.notes.presentaion.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                GlobalScreen()
            }
        }
    }
}

@Composable
fun GlobalScreen() {
    val navController = rememberNavController()
    val showDialog = remember {
        mutableStateOf(false)
    }
    NotesAddScreen(showDialog.value) {
        showDialog.value = false
    }
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog.value = true
                }
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add",
                    modifier = Modifier.scale(1.5f)
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.route
        ) {
            composable(Screens.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(Screens.ListScreen.route) {
                NoteListScreen()
            }
        }
    }
}








