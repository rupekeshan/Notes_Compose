package com.example.notes.presentaion.navigation

sealed class Screens(
    val route:String
) {
    object HomeScreen:Screens("home")
    object ListScreen:Screens("list")
}