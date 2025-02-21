package com.ds.dscomposeapp.di

import com.ds.dscomposeapp.data.api.KtorMuseumApi
import com.ds.dscomposeapp.data.api.MuseumApi
import com.ds.dscomposeapp.data.dataSources.implementations.MuseumRemoteDataSource
import com.ds.dscomposeapp.data.dataSources.interfaces.MuseumDataSource
import com.ds.dscomposeapp.data.repositories.DefaultMuseumRepository
import com.ds.dscomposeapp.data.repositories.MuseumRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module


val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<MuseumApi> { KtorMuseumApi(get()) }
    single<MuseumDataSource>(qualifier = named("remote")) { MuseumRemoteDataSource(get()) }
    single<MuseumRepository> {
        DefaultMuseumRepository(
            museumRemoteDataSource = get(named("remote"))
        ).apply {
            initialize()
        }
    }
}
