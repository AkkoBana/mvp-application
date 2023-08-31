package com.achiakkon.mvpapplication.data.di

import android.app.Application
import android.content.Context
import com.achiakkon.mvpapplication.data.NoteRepository
import com.achiakkon.mvpapplication.data.NoteRepositoryImpl
import com.achiakkon.mvpapplication.data.sharedpreferences.NoteSharedPreferencesImpl
import com.achiakkon.mvpapplication.domain.GetNoteDataUseCase
import com.achiakkon.mvpapplication.domain.GetNoteDataUseCaseImpl
import com.achiakkon.mvpapplication.domain.SetNoteDataUseCase
import com.achiakkon.mvpapplication.domain.SetNoteDataUseCaseImpl
import com.achiakkon.mvpapplication.domain.deletenotes.DeleteNotesUseCase
import com.achiakkon.mvpapplication.domain.deletenotes.DeleteNotesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class NoteDataModule {

    @Provides
    fun provideSetNoteDataUseCase(noteRepository: NoteRepository): SetNoteDataUseCase =
        SetNoteDataUseCaseImpl(noteRepository)

    @Provides
    fun provideGetNoteDataUseCase(noteRepository: NoteRepository): GetNoteDataUseCase =
        GetNoteDataUseCaseImpl(noteRepository)

    @Provides
    fun provideNoteRepository(noteSharedPreferences: NoteSharedPreferencesImpl): NoteRepository =
        NoteRepositoryImpl(noteSharedPreferences)

    @Provides
    fun provideDeleteNotesUseCase(noteRepository: NoteRepository): DeleteNotesUseCase =
        DeleteNotesUseCaseImpl(noteRepository)

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}