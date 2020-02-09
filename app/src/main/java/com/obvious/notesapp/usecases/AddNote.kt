package com.obvious.notesapp.usecases

import com.obvious.notesapp.domain.Note
import com.obvious.notesapp.data.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) =
        noteRepository.addNote(note)
}