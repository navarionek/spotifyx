package com.spotifyx.feature.background

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.spotifyx.core.app.App
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataReceiver: BroadcastReceiver() {

    @Inject
    lateinit var localDataSynchronizer: LocalDataSynchronizer

    override fun onReceive(context: Context?, intent: Intent?) {
        inject()
        localDataSynchronizer.onSync()
    }

    private fun inject() {
        App.getAppComponent().inject(this)
    }

}