package com.obvious.notesapp.presentation.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.obvious.notesapp.R
import com.obvious.notesapp.domain.Note
import com.obvious.notesapp.presentation.util.Constants
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.content_note.*
import java.util.*

//Activity for adding new note OR editing existing note
class NoteActivity : AppCompatActivity() {

    var action: String? = null
    lateinit var note : Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        setSupportActionBar(toolbar)
        action = intent.action

        if(action == Constants.EDIT_ACTION) {
            initView()
        }
    }

    fun initView() {
        note = intent.getParcelableExtra<Note>(Constants.INTENT_DATA_KEY)
        titleView.setText(note.title)
        contentView.setText(note.content)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {
                if(titleView.text.isNotEmpty() && contentView.text.isNotEmpty()) {
                    setReadOnlyText(titleView, true)
                    setReadOnlyText(contentView, true)
                    saveNote()
                } else {
                    val toast = Toast.makeText(this,getString(R.string.text_empty),Toast.LENGTH_SHORT)
                    toast.show()
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setReadOnlyText(editText: EditText, value: Boolean, inputType: Int = InputType.TYPE_NULL) {
        editText.isFocusable = !value
        editText.isFocusableInTouchMode = !value
        editText.inputType = inputType
    }

    override fun onBackPressed() {
      super.onBackPressed()
    }

    fun saveNote() {
        if(action == Constants.ADD_ACTION) {
            addNote()
        } else if(action == Constants.EDIT_ACTION) {
            updateNote()
        }
    }

    fun addNote() {
        val title = titleView.text.toString()
        val description = contentView.text.toString()
        note = Note(0, Date(),title,description)
        //sending the values via intent
        sendIntent(note)
    }

    fun sendIntent(note: Note?) {
        val intent = Intent()
        intent.putExtra(Constants.INTENT_DATA_KEY,note)
        setResult(Activity.RESULT_OK, intent)
    }

    fun updateNote() {
        val title = titleView.text.toString()
        val description = contentView.text.toString()
        note = Note(note.Id, Date(),title,description)
        sendIntent(note)
    }
}