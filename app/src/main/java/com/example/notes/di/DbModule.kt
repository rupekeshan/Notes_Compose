package com.example.notes.di

import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.notes.data.cache.NotesDb
import com.example.notes.data.cache.dao.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): NotesDb {
        return Room.databaseBuilder(
            context.applicationContext,
            NotesDb::class.java, "myDb"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDao(notesDb: NotesDb): NotesDao {
        return notesDb.notesDao()
    }

}