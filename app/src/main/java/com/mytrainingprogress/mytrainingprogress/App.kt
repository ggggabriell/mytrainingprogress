package com.mytrainingprogress.mytrainingprogress

import android.app.Application
import com.mytrainingprogress.mytrainingprogress.di.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidContext(this@App)
            modules(getModules())
        }
    }
}