package com.achiakkon.mvpapplication.presentation.notesscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.achiakkon.mvpapplication.data.Models.Note
import com.achiakkon.mvpapplication.databinding.FragmentNotesScreenBinding
import com.achiakkon.mvpapplication.presentation.MainApplication
import com.achiakkon.mvpapplication.presentation.notesscreen.adapter.NoteAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NotesScreenFragment : MvpAppCompatFragment(), NotesScreenView {

    private lateinit var adapter: NoteAdapter
    private lateinit var binding: FragmentNotesScreenBinding

    @InjectPresenter
    lateinit var notesScreenPresenter: NotesScreenPresenter

    @ProvidePresenter
    fun provideNotesScreenPresenter() = MainApplication.appComponent.provideNotesScreenPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = initialiseAdapter()
        //notesScreenPresenter.deleteNotes()
        notesScreenPresenter.getNotes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesScreenBinding.inflate(layoutInflater)
        createNote()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvNotesList.adapter = adapter
        createNote()
        noteCreated()
    }

    override fun updateRv(note: Note) {
        val currentNoteList = notesScreenPresenter.getNoteList().toMutableList()
        val newNoteList = listOf(note) + currentNoteList
        adapter.updateItems(newNoteList)
    }

    override fun updateRv(noteList: List<Note>) {
        adapter.updateItems(noteList)
    }

    private fun noteCreated() {
        val args =
            findNavController().currentBackStackEntry?.savedStateHandle?.get<Bundle>("args")
        notesScreenPresenter.addNewNote(args)
        findNavController().currentBackStackEntry?.savedStateHandle?.remove<Bundle>("args")
    }

    fun createNote() = with(binding) {
        bCreateNote.setOnClickListener {
            notesScreenPresenter.navigateToCreateNote()
        }
    }

    override fun navigateToCreateNote() {
        findNavController().navigate(NotesScreenFragmentDirections.actionNotesScreenToCreateNoteScreen())
    }

    override fun navigateToNoteScreen(note: String) {
        findNavController().navigate(
            NotesScreenFragmentDirections.actionNotesScreenToNoteScreen(
                note
            )
        )
    }

    private fun initialiseAdapter(): NoteAdapter {
        val noteAdapter = NoteAdapter(notesScreenPresenter.getNoteList().toMutableList()) {
            notesScreenPresenter.navigateToNoteScreen(it)
        }
        return noteAdapter
    }
}