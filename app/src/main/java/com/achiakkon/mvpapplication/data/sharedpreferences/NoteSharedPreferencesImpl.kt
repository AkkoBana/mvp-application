package com.achiakkon.mvpapplication.data.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject


class NoteSharedPreferencesImpl @Inject constructor(
    private val context: Context
) : NoteSharedPreferences {
    val sharedPreferences = context.getSharedPreferences("mynotes", Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = sharedPreferences.edit()

    override fun saveNote(note: String) {
        val notes = sharedPreferences.getString("Notes", "")
        if (notes!!.isNotEmpty()) {
            editor.putString("Notes", notes + '\n' + note).apply()
        } else {
            editor.putString("Notes", notes + note).apply()
        }

    }

    override fun getNotes(): String {
        return sharedPreferences.getString("Notes", "").toString()
    }

    override fun clearAllNotes() {
        editor.clear().commit();
    }


}