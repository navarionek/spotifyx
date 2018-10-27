package com.spotifyx.core.di

import android.app.Application
import com.spotifyx.core.auth.AuthModule
import com.spotifyx.feature.background.LocalDataReceiver
import com.spotifyx.feature.start.StartPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AuthModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    fun getPresenter(): StartPresenter
    fun inject(synchronizer: LocalDataReceiver)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
