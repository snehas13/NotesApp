package com.obvious.notesapp.data

import com.obvious.notesapp.domain.Note

class NoteRepository(private val dataSource: NoteDataSource) {
    suspend fun addNote(note : Note) = dataSource.addNote(note)
    suspend fun updateNote(note : Note) = dataSource.updateNote(note)
    suspend fun getNotes() = dataSource.getNotes()
}