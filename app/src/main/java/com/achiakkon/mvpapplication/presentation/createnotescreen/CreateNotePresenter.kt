package com.achiakkon.mvpapplication.presentation.createnotescreen

import androidx.core.os.bundleOf
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CreateNotePresenter @Inject constructor() : MvpPresenter<CreateNoteView>() {

    fun onButtonWasClicked(title: String, content: String) {
        val args = bundleOf("key" to title + '\n' + content)
        viewState.backToNotesScreen("args", args)
    }
}