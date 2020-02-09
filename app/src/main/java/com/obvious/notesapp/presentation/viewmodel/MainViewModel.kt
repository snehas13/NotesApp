package com.obvious.notesapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.obvious.notesapp.domain.Note
import com.obvious.notesapp.presentation.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application, interactors: Interactors)
    : NoteViewModel(application, interactors) {

    val notesLiveData: MutableLiveData<List<Note>> = MutableLiveData()

    //Database Operations in view model
    fun add(note: Note){
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                interactors.addNote(note)
            }
            fetchNotes()
        }
    }

    fun update(note: Note){
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                interactors.updateNote(note)
            }
            fetchNotes()
        }
    }

    fun fetchNotes() {
        GlobalScope.launch {
            notesLiveData.postValue(interactors.getNotes())
        }
    }
}