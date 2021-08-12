package com.example.notes.presentaion.screens.notelist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notes.presentaion.components.NotesListRow

@Composable
fun NoteListScreen(viewModel: NotesListViewModel = hiltViewModel()) {
    LazyColumn() {
        items(viewModel.noteList.value) { note ->
            NotesListRow(header = note.header,
                body = note.body,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp),
                onDelete = {
                    viewModel.deleteList(note)
                })
        }
    }
}