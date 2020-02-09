package com.obvious.notesapp.data

import com.obvious.notesapp.domain.Note


interface NoteDataSource {
    suspend fun addNote(note : Note)
    suspend fun updateNote(note : Note)
    suspend fun getNotes() : List<Note>
}