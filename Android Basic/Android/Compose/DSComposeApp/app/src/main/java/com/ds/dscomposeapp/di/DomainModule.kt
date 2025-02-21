package com.ds.dscomposeapp.di

import com.ds.dscomposeapp.domain.mappers.DefaultMuseumEntityMapper
import com.ds.dscomposeapp.domain.mappers.MuseumEntityMapper
import com.ds.dscomposeapp.domain.usecases.DefaultGetMuseumUseCase
import com.ds.dscomposeapp.domain.usecases.DefaultGetMuseumsUseCase
import com.ds.dscomposeapp.domain.usecases.GetMuseumUseCase
import com.ds.dscomposeapp.domain.usecases.GetMuseumsUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<MuseumEntityMapper> { DefaultMuseumEntityMapper() }
    factory<GetMuseumUseCase> { DefaultGetMuseumUseCase(get(), get()) }
    factory<GetMuseumsUseCase> { DefaultGetMuseumsUseCase(get(), get()) }
}