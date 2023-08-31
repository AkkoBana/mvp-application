package com.achiakkon.mvpapplication.presentation.notescreen

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class NoteScreenPresenter @Inject constructor() : MvpPresenter<NoteScreenView>() {

    fun setNote(args: NoteScreenFragmentArgs) {
        val splitText = args.note.split('\n', limit = 2)
        viewState.showNote(splitText[0], splitText[1])
    }

}