package com.achiakkon.mvpapplication.domain.deletenotes

import com.achiakkon.mvpapplication.data.NoteRepository
import javax.inject.Inject

class DeleteNotesUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository) :
    DeleteNotesUseCase {
    override fun deleteNotes() {
        noteRepository.deleteNotes()
    }
}