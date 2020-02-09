package com.obvious.notesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.obvious.notesapp.presentation.util.Converters

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {


    companion object {

        private var instance : NoteDatabase?= null

        private const val DATABASE_NAME = "notes.db"

        fun getDatabase(context : Context) : NoteDatabase? {
            if(instance == null) {
                instance = Room.databaseBuilder(context,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return instance
        }
    }

    abstract fun noteDao() : NoteDao

}