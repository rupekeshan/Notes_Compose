package com.example.notes.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.cache.dao.NotesDao
import com.example.notes.data.cache.entity.NotesCache


@Database(entities = [NotesCache::class], version = 1)
abstract class NotesDb : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}