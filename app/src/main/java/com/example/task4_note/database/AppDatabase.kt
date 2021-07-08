package com.example.task4_note.database

import android.content.Context
import androidx.room.*
import java.io.Serializable

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

@Entity
data class Note(
    val date: String,
    var title: String,
    var body: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

@Dao
interface NoteDao {
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getById(id: Long): Note

    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insert(note: Note)
}
