package com.example.notes.presentaion.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notes.R


@Composable
fun HomeScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.noteim),
            contentDescription = "Note",
            Modifier.width(150.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { navController.navigate("list") }) {
            Text(text = "Start")
        }
    }
}

