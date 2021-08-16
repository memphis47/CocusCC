package com.cocus.cocuscc.di

import android.app.Application
import dagger.Module
import dagger.Provides

import javax.inject.Singleton


@Module
class AppModule(var mApplication: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
}