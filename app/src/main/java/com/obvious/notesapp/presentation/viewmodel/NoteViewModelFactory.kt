package com.obvious.notesapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.obvious.notesapp.presentation.Interactors

object NoteViewModelFactory : ViewModelProvider.Factory {

  lateinit var application: Application

  lateinit var dependencies: Interactors

  fun inject(application: Application, dependencies: Interactors) {
    NoteViewModelFactory.application = application
    NoteViewModelFactory.dependencies = dependencies
  }

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(NoteViewModel::class.java.isAssignableFrom(modelClass)) {
      return modelClass.getConstructor(Application::class.java, Interactors::class.java)
          .newInstance(
            application,
            dependencies
          )
    } else {
      throw IllegalStateException("All ViewModel of app must extend NoteViewModel")
    }
  }

}
