package com.ds.kmmproject.di

import com.ds.kmmproject.data.database.MuseumsDatabase
import com.ds.kmmproject.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<MuseumsDatabase> { getDatabaseBuilder(get()) }
}