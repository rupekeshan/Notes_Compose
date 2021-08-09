package com.example.notes.repository

import com.example.notes.data.cache.dao.NotesDao
import com.example.notes.data.cache.entity.CacheMapper
import com.example.notes.domain.Notes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class NotesRepository @Inject constructor(val notesDao: NotesDao,val cacheMapper: CacheMapper) {

    suspend fun insert(notes: Notes): Long {
        val todoEntityForCache = cacheMapper.mapToEntity(notes)
        Timber.e("In insert")
        return notesDao.addData(todoEntityForCache)
    }

    suspend fun getAllDetail(): List<Notes> {
        Timber.e("in All Details")
        return cacheMapper.mapFromListEntity(notesDao.getAllData())
    }

    suspend fun deleteData(notes: Notes): Int {
        val todoEntityForCache = cacheMapper.mapToEntity(notes)
        return notesDao.deleteData(todoEntityForCache)
    }

}