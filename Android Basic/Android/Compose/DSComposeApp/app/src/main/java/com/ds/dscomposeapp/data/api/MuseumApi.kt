package com.ds.dscomposeapp.data.api

import com.ds.dscomposeapp.data.models.MuseumEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.coroutines.cancellation.CancellationException

interface MuseumApi {
    suspend fun getData(): List<MuseumEntity>
}

class KtorMuseumApi(private val client: HttpClient) : MuseumApi {
    companion object {
        private const val API_URL =
            "https://raw.githubusercontent.com/Kotlin/KMP-App-Template-Native/main/list.json"
    }

    override suspend fun getData(): List<MuseumEntity> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
    }
}