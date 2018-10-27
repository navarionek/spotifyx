package com.spotifyx.core.data

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return buildDatabase(context)
    }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java, "pawelsuperkolega.db")
            .build()
}