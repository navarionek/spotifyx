package com.spotifyx.feature.start

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotifyx.R
import com.spotifyx.core.app.App
import com.spotifyx.core.mvp.MvpPresenter

class StartActivity : AppCompatActivity(), StartContract.View {

    private lateinit var presenter: StartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = getPresenter()
        presenter.init()
    }


    private fun onSpotifyConnected(spotifyRemote: SpotifyAppRemote) {
            spotifyRemote.playerApi.subscribeToPlayerState()
                .setEventCallback { Log.d("fifi", "Track: ${it.track}, whole: $it") }
    }

    override fun getPresenter(): StartPresenter = App.getAppComponent().getPresenter()
}

class SpotifyListener constructor(var block: (spotifyRemote: SpotifyAppRemote) -> Unit) : Connector.ConnectionListener {

    override fun onConnected(spotifyRemote: SpotifyAppRemote) {
        block(spotifyRemote)
    }

    override fun onFailure(throwable: Throwable) {
        throwable.printStackTrace()
    }
}