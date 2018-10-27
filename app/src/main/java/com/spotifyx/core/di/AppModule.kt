package com.spotifyx.core.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideContext(app: Application): Context = app
    }
}
