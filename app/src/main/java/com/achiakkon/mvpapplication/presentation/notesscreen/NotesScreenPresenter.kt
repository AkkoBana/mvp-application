package com.achiakkon.mvpapplication.presentation.notesscreen

import android.os.Bundle
import com.achiakkon.mvpapplication.data.Models.Note
import com.achiakkon.mvpapplication.domain.GetNoteDataUseCase
import com.achiakkon.mvpapplication.domain.SetNoteDataUseCase
import com.achiakkon.mvpapplication.domain.deletenotes.DeleteNotesUseCase
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class NotesScreenPresenter @Inject constructor(
    private val setNoteDataUseCase: SetNoteDataUseCase,
    private val getNoteDataUseCase: GetNoteDataUseCase,
    private val deleteNotes: DeleteNotesUseCase
) : MvpPresenter<NotesScreenView>() {

    private var noteList: MutableList<Note> = mutableListOf()

    fun addNewNote(note: Bundle?) {

        if (note != null) {
            val noteText = note.getString("key").toString()
            note.clear()

            val splitNote = noteText.split('\n', limit = 2)
            val newItem = Note(splitNote[0], splitNote[1])

            setNoteDataUseCase.saveNote(noteText)
            viewState.updateRv(newItem)
        }
    }

    fun getNotes() {
        val notes = getNoteDataUseCase.getNotes().lines()
        if (notes.size != 1) {
            for (index in 0..notes.size - 1) {
                if (index % 2 == 0) {
                    noteList.add(Note(notes[index], notes[index + 1]))
                }
            }
        }
        viewState.updateRv(noteList)
    }

    fun getNoteList(): List<Note> {
        return noteList
    }

    fun navigateToCreateNote() {
        viewState.navigateToCreateNote()
    }

    fun navigateToNoteScreen(note: Note) {
        viewState.navigateToNoteScreen(note.title + '\n' + note.content)
    }

    fun deleteNotes() {
        deleteNotes.deleteNotes()
    }
}