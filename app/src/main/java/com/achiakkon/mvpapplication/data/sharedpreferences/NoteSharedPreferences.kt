package com.achiakkon.mvpapplication.data.sharedpreferences

interface NoteSharedPreferences {
    fun saveNote(note: String)
    fun getNotes(): String
    fun clearAllNotes()
}