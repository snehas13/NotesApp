package com.obvious.notesapp.presentation

import android.app.Application
import com.obvious.notesapp.data.NoteDataSourceImpl
import com.obvious.notesapp.data.NoteRepository
import com.obvious.notesapp.presentation.viewmodel.NoteViewModelFactory
import com.obvious.notesapp.usecases.AddNote
import com.obvious.notesapp.usecases.FetchNotes
import com.obvious.notesapp.usecases.UpdateNote

class NoteAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val noteRepository = NoteRepository(NoteDataSourceImpl(this))
        NoteViewModelFactory.inject(
            this,
            Interactors(
                AddNote(noteRepository), UpdateNote(noteRepository), FetchNotes(noteRepository)
            )
        )
    }
}