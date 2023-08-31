package com.achiakkon.mvpapplication.presentation.createnotescreen

import android.os.Bundle
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface CreateNoteView : MvpView {
    fun backToNotesScreen(key: String, args: Bundle)
}