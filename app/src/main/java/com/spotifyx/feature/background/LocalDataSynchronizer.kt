package com.spotifyx.feature.background

import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.types.PlayerState
import com.spotifyx.core.auth.Authenticator
import com.spotifyx.core.entity.Album
import com.spotifyx.core.entity.Artist
import com.spotifyx.core.entity.Track
import com.spotifyx.core.services.AlarmService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSynchronizer
    @Inject constructor(
        private val alarmService: AlarmService,
        private val authenticator: Authenticator
    ): DataSynchronizer {

    override fun initSync() {
        alarmService.setRepeatingAlarm(60, LocalDataReceiver::class.java, 1)
    }

    fun onSync() {
//        authenticator.connect()
//            .flatMapObservable(this::subscribeToPlayer)
//            .map(this::mapEntity)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//
//            }, {
//
//            })
    }

//    private fun mapEntity(playerState: PlayerState): SpotifyPlayerState {
//        playerState.track.imageUri
////        playerState.
//    }
    
    private fun subscribeToPlayer(remote: SpotifyAppRemote): Observable<PlayerState> {
        return Observable.fromPublisher { subscriber ->
            remote.playerApi.subscribeToPlayerState().setEventCallback { subscriber.onNext(it) }
        }
    }

    private fun mapEntity(playerState: PlayerState) = playerState.track.let {

                val artists: MutableList<Artist> = emptyList<Artist>().toMutableList()
                it.artists.forEach { artists.add(Artist(it.name, it.uri)) }

            Track(
                Artist(it.artist.name, it.artist.uri),
                artists,
                Album(it.album.name, it.album.uri),
                it.duration,
                it.name,
                it.uri,
                it.imageUri.raw)
        }
}
