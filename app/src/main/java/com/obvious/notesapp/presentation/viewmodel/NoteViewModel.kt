package com.obvious.notesapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.obvious.notesapp.presentation.Interactors
import com.obvious.notesapp.presentation.NoteAplication

open class NoteViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {

  protected val application: NoteAplication = getApplication()

}
