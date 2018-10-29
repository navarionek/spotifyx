package com.spotifyx.core.app

import android.app.Application
import com.spotifyx.core.di.AppComponent
import com.spotifyx.core.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {

        private lateinit var INSTANCE: AppComponent

        fun getAppComponent(): AppComponent {
            return INSTANCE
        }
    }
}