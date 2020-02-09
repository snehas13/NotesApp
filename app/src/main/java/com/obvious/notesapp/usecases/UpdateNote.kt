package com.obvious.notesapp.usecases

import com.obvious.notesapp.domain.Note
import com.obvious.notesapp.data.NoteRepository


class UpdateNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) =
        noteRepository.updateNote(note)
}