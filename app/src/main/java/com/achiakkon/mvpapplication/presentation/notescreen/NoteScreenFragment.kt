package com.achiakkon.mvpapplication.presentation.notescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.achiakkon.mvpapplication.databinding.FragmentNoteScreenBinding
import com.achiakkon.mvpapplication.presentation.MainApplication
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NoteScreenFragment : MvpAppCompatFragment(), NoteScreenView {

    lateinit var binding: FragmentNoteScreenBinding
    val args: NoteScreenFragmentArgs by navArgs()

    @InjectPresenter
    lateinit var noteScreenPresenter: NoteScreenPresenter
    @ProvidePresenter
    fun provideNoteScreenPresenter() = MainApplication.appComponent.provideNoteScreenPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteScreenBinding.inflate(layoutInflater)
        noteScreenPresenter.setNote(args)
        return binding.root
    }

    override fun showNote(title: String, content: String) = with(binding){
        tvTitle.text = title
        tvContent.text = content
    }


}