package com.ds.kmmproject.app

import android.app.Application
import com.ds.kmmproject.di.initKoin
import com.ds.kmmproject.presentation.detail.DetailViewModel
import com.ds.kmmproject.presentation.list.ListViewModel
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class MuseumApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MuseumApp)
        }

        initKoin(
            listOf(
                module {
                    viewModel { DetailViewModel(get()) }
                    viewModel { ListViewModel(get()) }
                }
            )
        )
    }
}
