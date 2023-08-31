package com.achiakkon.mvpapplication.data.di

import android.app.Application
import com.achiakkon.mvpapplication.presentation.createnotescreen.CreateNotePresenter
import com.achiakkon.mvpapplication.presentation.notescreen.NoteScreenPresenter
import com.achiakkon.mvpapplication.presentation.notesscreen.NotesScreenPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NoteDataModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun provideNotesScreenPresenter(): NotesScreenPresenter
    fun provideCreateNotePresenter(): CreateNotePresenter
    fun provideNoteScreenPresenter(): NoteScreenPresenter
}