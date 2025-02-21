package com.ds.kmmproject.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.mp.KoinPlatform.getKoin

expect fun platformModule(): Module

fun initKoin() = initKoin(emptyList())

fun initKoin(extraModules: List<Module>) {
    val koin = try {
        getKoin()
    } catch (e: Exception) {
        null
    }

    koin?.let {
        koin.loadModules(
            listOf(
                platformModule(),
                dataModule,
                domainModule,
                *extraModules.toTypedArray()
            )
        )
    } ?: run {
        startKoin {
            modules(
                platformModule(),
                dataModule,
                domainModule,
                *extraModules.toTypedArray()
            )
        }
    }
}
