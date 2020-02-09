package com.obvious.notesapp.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.obvious.notesapp.R
import com.obvious.notesapp.domain.Note
import com.obvious.notesapp.presentation.util.Constants
import com.obvious.notesapp.presentation.adapter.NoteAdapter
import com.obvious.notesapp.presentation.viewmodel.MainViewModel
import com.obvious.notesapp.presentation.viewmodel.NoteViewModelFactory

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),NoteAdapter.ItemSelectListener {

    lateinit var viewModel: MainViewModel
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProvider(this, NoteViewModelFactory)
            .get(MainViewModel::class.java)

        noteRecyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter(this)
        noteRecyclerView.adapter = noteAdapter

        viewModel.notesLiveData.observe(this, Observer { noteAdapter.update(it) })
        viewModel.fetchNotes()

        //Floating action button
        fab.setOnClickListener {
            sendAddIntent()
        }
    }

    override fun onItemClick(position: Int) {
        val note = noteAdapter.getNoteAt(position)
        sendEditIntent(note)
    }

    fun sendEditIntent(note: Note) {
        var intent = Intent(this,NoteActivity::class.java)
        intent.putExtra(Constants.INTENT_DATA_KEY,note)
        intent.action = Constants.EDIT_ACTION
        startActivityForResult(intent, Constants.REQUESTCODE_EDIT)
    }

    fun sendAddIntent() {
        var intent = Intent(this,NoteActivity::class.java)
        intent.action = Constants.ADD_ACTION
        startActivityForResult(intent, Constants.REQUESTCODE_ADD)
    }

    //getting result back from note activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if(requestCode == Constants.REQUESTCODE_ADD && resultCode == Activity.RESULT_OK){
            val note = intent?.getParcelableExtra<Note>(Constants.INTENT_DATA_KEY)
            if (note != null) {
                viewModel.add(note)
            }
        }
        if(requestCode == Constants.REQUESTCODE_EDIT && resultCode== Activity.RESULT_OK){
            val note = intent?.getParcelableExtra<Note>(Constants.INTENT_DATA_KEY)
            if (note != null) {
                viewModel.update(note)
            }
        }
    }

}
