package com.ds.kmmproject.data.repositories

import com.ds.kmmproject.data.dataSources.interfaces.MuseumDataSource
import com.ds.kmmproject.data.models.MuseumEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

interface MuseumRepository {
    fun initialize()
    suspend fun getMuseums(): List<MuseumEntity>
    suspend fun getMuseumById(museumId: Long): MuseumEntity?
}

class DefaultMuseumRepository(
    private val museumLocalDataSource: MuseumDataSource,
    private val museumRemoteDataSource: MuseumDataSource,
) : MuseumRepository {
    private val scope = CoroutineScope(SupervisorJob())

    override fun initialize() {
        scope.launch {
            refresh()
        }
    }

    override suspend fun getMuseums() = museumLocalDataSource.fetchMuseums()

    override suspend fun getMuseumById(museumId: Long) = museumLocalDataSource.getMuseumsById(museumId)

    private suspend fun refresh() {
        museumLocalDataSource.saveMuseums(
            museumRemoteDataSource.fetchMuseums()
        )
    }
}
