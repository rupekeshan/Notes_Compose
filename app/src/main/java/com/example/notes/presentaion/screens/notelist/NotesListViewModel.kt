package com.example.notes.presentaion.screens.notelist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.Notes
import com.example.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {
    init {
        getAllList()
    }

    var noteList = mutableStateOf<List<Notes>>(arrayListOf())

    fun getAllList() {
        viewModelScope.launch {
            val result = notesRepository.getAllDetail()
            noteList.value = result
            Timber.e(noteList.toString())
        }
    }

    fun deleteList(notes: Notes) {
        viewModelScope.launch {
            notesRepository.deleteData(notes)
            getAllList()
        }
    }

}