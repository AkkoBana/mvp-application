package com.achiakkon.mvpapplication.domain

import com.achiakkon.mvpapplication.data.NoteRepository
import javax.inject.Inject

class SetNoteDataUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository) :
    SetNoteDataUseCase {
    override fun saveNote(note: String) {
        noteRepository.saveNote(note)
    }
}