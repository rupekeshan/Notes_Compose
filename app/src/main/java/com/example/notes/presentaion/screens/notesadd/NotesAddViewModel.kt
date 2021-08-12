package com.example.notes.presentaion.screens.notesadd

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.Notes
import com.example.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesAddViewModel @Inject constructor(
    val notesRepository: NotesRepository
) : ViewModel() {
    
    val header = mutableStateOf("")
    val body = mutableStateOf("")

    fun addList() {
        viewModelScope.launch {
            notesRepository.insert(Notes(header.value, body.value))
            header.value = ""
            body.value = ""
        }
    }

    fun onChangeHeader(text: String) {
        header.value = text
    }

    fun onChangeBody(text: String) {
        body.value = text
    }
}