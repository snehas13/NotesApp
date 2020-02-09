package com.obvious.notesapp.usecases

import com.obvious.notesapp.data.NoteRepository


class FetchNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() = noteRepository.getNotes()
}