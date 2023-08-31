package com.achiakkon.mvpapplication.presentation.notescreen

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface NoteScreenView : MvpView {
    fun showNote(title: String, content: String)
}