package com.obvious.notesapp.data

import androidx.room.Entity
import java.util.Date
import androidx.room.PrimaryKey

// Create NoteEntity table with id,date,title and content columns
@Entity(tableName = "NoteTable")
class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date : Date,
    val title : String,
    val content : String)