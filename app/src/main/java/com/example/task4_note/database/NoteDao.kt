package com.example.task4_note.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.task4_note.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getById(id: Long): Note

    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)
}
