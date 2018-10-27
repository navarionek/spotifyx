package com.spotifyx.core.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.spotifyx.core.entity.SpotifyPlayerState
import io.reactivex.Flowable

@Dao
interface PlayerStateDao {

    /**
     * Get a user by id.
     * @return the user from the table with a specific id.
     */
    @Query("SELECT * FROM SpotifyPlayerState")
    fun getAll(): Flowable<SpotifyPlayerState>

    /**
     * Insert a user in the database. If the user already exists, replace it.
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: SpotifyPlayerState)

    /**
     * Delete all users.
     */
    @Query("DELETE FROM SpotifyPlayerState")
    fun deleteAll()

}