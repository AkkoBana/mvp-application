package com.achiakkon.mvpapplication.domain

import com.achiakkon.mvpapplication.data.NoteRepository
import javax.inject.Inject

class GetNoteDataUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository) :
    GetNoteDataUseCase {
    override fun getNotes(): String {
        return noteRepository.getNotes()
    }
}