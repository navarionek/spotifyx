package com.spotifyx.core.auth

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotifyx.feature.start.SpotifyListener
import io.reactivex.Single
import org.reactivestreams.Publisher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Authenticator @Inject constructor(
    val context: Context
) {

    private var spotifyRemote: SpotifyAppRemote? = null

    fun connect(): Single<SpotifyAppRemote> {
        return if(isConnected()) {
            Single.just(spotifyRemote)
        } else {
            Single.fromPublisher {
                SpotifyAppRemote.connect(
                    context, getConnectionParams(),
                    SpotifyListener { remote -> it.onNext(remote) }
                )
            }
        }
    }

    fun isConnected(): Boolean {
        spotifyRemote?.let {
            return it.isConnected
        }
        return false
    }

     private fun getConnectionParams(): ConnectionParams =
        ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

    fun disconnect() {
        if(isConnected()) {
            // TODO
        }
    }

    companion object {
        private val CLIENT_ID = "6b7cfeb34374465fa280b131406adc81"
        private val REDIRECT_URI = "spotifyx://launch"
    }
}