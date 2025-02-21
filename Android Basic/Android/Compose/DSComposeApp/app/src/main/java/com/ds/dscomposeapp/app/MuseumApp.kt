package com.ds.dscomposeapp.app

import android.app.Application
import com.ds.dscomposeapp.di.dataModule
import com.ds.dscomposeapp.di.domainModule
import com.ds.dscomposeapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MuseumApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MuseumApp)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}
