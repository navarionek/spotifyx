package com.spotifyx.core.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Artist(
    val name: String,
    val uri: String
)


@Entity
data class SpotifyPlayerState(
    @PrimaryKey @ColumnInfo(name = "id") val id: String)