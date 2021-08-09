package com.example.notes.presentaion.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotesListRow(
    header: String,
    body: String,
    modifier: Modifier = Modifier,
    onDelete: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Column() {
            Text(
                text = header,
                style = MaterialTheme.typography.h4,
            )
            Text(text = body, modifier = Modifier.padding(start = 20.dp))
        }
        IconButton(onClick = {onDelete() }) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = Color.Red)
        }
    }
}