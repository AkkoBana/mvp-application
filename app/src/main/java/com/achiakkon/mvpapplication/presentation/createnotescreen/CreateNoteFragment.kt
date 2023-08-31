package com.achiakkon.mvpapplication.presentation.createnotescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.achiakkon.mvpapplication.databinding.FragmentCreateNoteScreenBinding
import com.achiakkon.mvpapplication.presentation.MainApplication
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class CreateNoteFragment : MvpAppCompatFragment(), CreateNoteView {
    lateinit var binding: FragmentCreateNoteScreenBinding

    @InjectPresenter
    lateinit var createNotePresenter: CreateNotePresenter

    @ProvidePresenter
    fun provideCreateNotePresenter() = MainApplication.appComponent.provideCreateNotePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNoteScreenBinding.inflate(layoutInflater)
        onClickCreated()
        return binding.root
    }

    fun onClickCreated() = with(binding) {
        bAddNote.setOnClickListener {
            val titleText = etTitle.text.toString()
            val contentText = etContent.text.toString()
            createNotePresenter.onButtonWasClicked(titleText, contentText)
        }
    }

    override fun backToNotesScreen(key: String, args: Bundle) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, args)
        findNavController().popBackStack()
    }
}