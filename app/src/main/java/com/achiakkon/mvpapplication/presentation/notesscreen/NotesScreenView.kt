package com.achiakkon.mvpapplication.presentation.notesscreen

import com.achiakkon.mvpapplication.data.Models.Note
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface NotesScreenView : MvpView {
    fun updateRv(note: Note)
    fun navigateToCreateNote()
    fun navigateToNoteScreen(note: String)
    fun updateRv(noteList: List<Note>)
}