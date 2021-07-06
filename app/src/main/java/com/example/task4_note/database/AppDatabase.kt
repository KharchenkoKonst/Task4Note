package com.example.task4_note.database

import android.content.Context
import androidx.room.*

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
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
    @PrimaryKey(autoGenerate = true)
    val id: Long, val title: String,
    val body: String, val date: String
)

@Dao
interface NoteDao {
    @Query("SELECT * FROM note WHERE id = :id")
    fun getById(id: Long): Note

    @Insert
    fun insert(note: Note)

}
