package com.example.notes.data.cache.entity

import com.example.notes.domain.Notes
import com.example.notes.util.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<NotesCache, Notes> {
    override fun mapFromEntity(entity: NotesCache): Notes {
        return Notes(id = entity.id, header = entity.header, body = entity.body)
    }

    override fun mapToEntity(domainModel: Notes): NotesCache {
        return NotesCache(id = domainModel.id, header = domainModel.header, body = domainModel.body)
    }

    fun mapFromListEntity(entities: List<NotesCache>): List<Notes> {
        return entities.map {
            mapFromEntity(it)
        }
    }

}