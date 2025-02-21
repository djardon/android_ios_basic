package com.ds.kmmproject.di

import com.ds.kmmproject.domain.mappers.DefaultMuseumEntityMapper
import com.ds.kmmproject.domain.mappers.MuseumEntityMapper
import com.ds.kmmproject.domain.usecases.DefaultGetMuseumUseCase
import com.ds.kmmproject.domain.usecases.DefaultGetMuseumsUseCase
import com.ds.kmmproject.domain.usecases.GetMuseumUseCase
import com.ds.kmmproject.domain.usecases.GetMuseumsUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<MuseumEntityMapper> { DefaultMuseumEntityMapper() }
    factory<GetMuseumUseCase> { DefaultGetMuseumUseCase(get(), get()) }
    factory<GetMuseumsUseCase> { DefaultGetMuseumsUseCase(get(), get()) }
}