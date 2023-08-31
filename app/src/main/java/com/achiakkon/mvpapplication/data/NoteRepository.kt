package com.achiakkon.mvpapplication.data

interface NoteRepository {
    fun saveNote(note: String)
    fun getNotes(): String
    fun deleteNotes()
}