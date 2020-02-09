package com.obvious.notesapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insert(note : NoteEntity)

    @Update
    fun update(noteEntity : NoteEntity)

    @Query("select * from NoteTable ORDER BY datetime(date) DESC")
    fun getNotes(): List<NoteEntity>
}