package com.spotifyx.core.di

import com.spotifyx.core.auth.AuthModule
import com.spotifyx.feature.background.LocalDataReceiver
import com.spotifyx.feature.background.LocalDataSynchronizer
import com.spotifyx.feature.start.StartActivity
import com.spotifyx.feature.start.StartPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AuthModule::class])
interface AppComponent {

    fun getPresenter(): StartPresenter
    fun inject(synchronizer: LocalDataReceiver)
}