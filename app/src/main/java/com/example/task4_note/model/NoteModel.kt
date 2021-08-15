package com.example.task4_note.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
@Parcelize
data class Note(
    val date: String,
    var title: String,
    var body: String
) : Serializable, Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
