package com.obvious.notesapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Note (
    val Id : Int,
    val date : Date,
    val title :  String,
    val content :  String
) : Parcelable