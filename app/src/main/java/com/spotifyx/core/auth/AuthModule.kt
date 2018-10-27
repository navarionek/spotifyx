package com.spotifyx.core.auth

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AuthModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideAuthenticator(context: Context): Authenticator {
            return Authenticator(context)
        }
    }
}
