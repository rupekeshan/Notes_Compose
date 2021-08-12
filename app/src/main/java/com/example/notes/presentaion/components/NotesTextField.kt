package com.example.notes.presentaion.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotesTextField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (text: String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        modifier = modifier,
        placeholder = {
            Text(text = "Start Typing ....")
        },
        maxLines = 1,
    )
}