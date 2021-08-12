package com.example.notes.presentaion.screens.notesadd

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notes.domain.Notes
import com.example.notes.presentaion.components.NotesTextField
import timber.log.Timber

@Composable
fun NotesAddScreen(
    showDialog: Boolean,
    viewModel: NotesAddViewModel = hiltViewModel(),
    onChange: () -> Unit,
) {
    if (showDialog) {
        Dialog(onDismissRequest = {
            onChange()
            viewModel.header.value = ""
            viewModel.body.value = ""
        }, properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true)) {
            Surface(
                modifier = Modifier.height(300.dp),
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(5.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    NotesTextField(
                        value = viewModel.header.value,
                        label = "Header",
                        onValueChange = {
                            viewModel.onChangeHeader(it)
                        })
                    Spacer(modifier = Modifier.height(20.dp))
                    NotesTextField(value = viewModel.body.value, label = "Body", onValueChange = {
                        viewModel.onChangeBody(it)
                    })
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {
                        viewModel.addList()
                        onChange()
                    }) {
                        Text("Add")
                    }
                }
            }
        }
    }
}