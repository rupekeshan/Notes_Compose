package com.example.notes.presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.presentaion.navigation.Screens
import com.example.notes.presentaion.screens.home.HomeScreen
import com.example.notes.presentaion.screens.notelist.NoteListScreen
import com.example.notes.presentaion.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                val navController = rememberNavController()
                Scaffold(
                    backgroundColor = MaterialTheme.colors.background,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {

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
        }
    }
}








