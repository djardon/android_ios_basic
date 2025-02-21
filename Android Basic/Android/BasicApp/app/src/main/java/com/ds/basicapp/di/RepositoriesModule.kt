package com.ds.basicapp.di

import com.ds.basicapp.domain.repositories.LocalDataRepository
import com.ds.basicapp.domain.repositories.LocalDataRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single <LocalDataRepository> { LocalDataRepositoryImpl(get()) }
}