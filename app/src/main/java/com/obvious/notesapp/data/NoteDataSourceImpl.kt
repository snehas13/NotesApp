package com.obvious.notesapp.data

import android.content.Context
import com.obvious.notesapp.domain.Note

class NoteDataSourceImpl(context: Context) : NoteDataSource {

    private val noteDao = NoteDatabase.getDatabase(context)!!.noteDao()

    override suspend fun addNote(note: Note) {
        return noteDao.insert(
            NoteEntity(
                0,
                note.date,
                note.title,
                note.content
            )
        )
    }

    override suspend fun updateNote(note: Note) {
        return noteDao.update(
            NoteEntity(
                note.Id,
                note.date,
                note.title,
                note.content
            )
        )
    }


    override suspend fun getNotes(): List<Note> {
        return noteDao.getNotes().map { Note(it.id, it.date, it.title ,it.content)}
    }

}