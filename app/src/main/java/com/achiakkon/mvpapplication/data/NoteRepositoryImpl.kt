package com.achiakkon.mvpapplication.data

import com.achiakkon.mvpapplication.data.sharedpreferences.NoteSharedPreferencesImpl
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteSharedPreferences: NoteSharedPreferencesImpl
) : NoteRepository {

    override fun saveNote(note: String) {
        noteSharedPreferences.saveNote(note)
    }

    override fun getNotes(): String {
        return noteSharedPreferences.getNotes()
    }

    override fun deleteNotes() {
        noteSharedPreferences.clearAllNotes()
    }


}