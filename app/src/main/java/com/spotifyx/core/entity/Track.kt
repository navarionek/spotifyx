package com.spotifyx.core.entity

data class Track(
    val artist: Artist,
    val artists: List<Artist>,
    val album: Album,
    val duration: Long,
    val name: String,
    val uri: String,
    val imageUri: String
)