package com.spotifyx.core.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.spotifyx.core.entity.SpotifyPlayerState

@Database(entities = [SpotifyPlayerState::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerStateDao(): PlayerStateDao
}
