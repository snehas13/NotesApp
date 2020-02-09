package com.obvious.notesapp.presentation.util

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date

class Converters {
    private var df: SimpleDateFormat = SimpleDateFormat(Constants.TIME_STAMP_FORMAT)

    @TypeConverter
    fun fromTimestamp(value: String?): Date? {
        return if (value == null) null else df.parse(value)
    }

    @TypeConverter
    fun dateToTimestamp(value: Date?): String? {
        return if (value == null) null else df.format(value)
    }
}