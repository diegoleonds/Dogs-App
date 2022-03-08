package com.example.dogsapp.config

import android.app.Application
import com.example.dogsapp.data.di.dataModule
import com.example.dogsapp.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    /**
     * Base Application class for the app
     * Start koin for dependency injection
     */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(dataModule, uiModule)
        }
    }
}