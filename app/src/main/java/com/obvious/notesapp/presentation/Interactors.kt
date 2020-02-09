package com.obvious.notesapp.presentation

import com.obvious.notesapp.usecases.AddNote
import com.obvious.notesapp.usecases.FetchNotes
import com.obvious.notesapp.usecases.UpdateNote


data class Interactors(
    val addNote: AddNote,
    val updateNote: UpdateNote,
    val getNotes: FetchNotes
)
