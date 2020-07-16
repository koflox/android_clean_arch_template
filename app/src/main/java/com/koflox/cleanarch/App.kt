package com.koflox.cleanarch

import android.app.Application
import com.koflox.cleanarch.di.appModules
import com.koflox.cleanarch.util.Network
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        Network.init(this)
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

}