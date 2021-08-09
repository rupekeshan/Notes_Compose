package com.example.notes.data.cache.dao

import androidx.room.*
import com.example.notes.data.cache.entity.NotesCache
import kotlinx.coroutines.flow.Flow


@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllDataWithLive(): Flow<List<NotesCache>>

    @Query("SELECT * FROM notes")
    suspend fun getAllData(): List<NotesCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(todoEntityForCache:NotesCache):Long

    @Delete
    suspend fun deleteData(todoEntityForCache:NotesCache):Int
}