package com.ds.kmmproject.di

import com.ds.kmmproject.data.database.MuseumsDatabase
import com.ds.kmmproject.data.database.getDatabaseBuilder
import com.ds.kmmproject.domain.usecases.GetMuseumUseCase
import com.ds.kmmproject.domain.usecases.GetMuseumsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module

class KoinDependencies: KoinComponent {
    val getMuseumsUseCase: GetMuseumsUseCase by inject()
    val getMuseumUseCase: GetMuseumUseCase by inject()
}

actual fun platformModule() = module {
    single<MuseumsDatabase> { getDatabaseBuilder() }
}
