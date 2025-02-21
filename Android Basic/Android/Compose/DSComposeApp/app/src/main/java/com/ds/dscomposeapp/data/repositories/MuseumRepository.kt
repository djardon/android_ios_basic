package com.ds.dscomposeapp.data.repositories

import com.ds.dscomposeapp.data.dataSources.interfaces.MuseumDataSource
import com.ds.dscomposeapp.data.models.MuseumEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

interface MuseumRepository {
    fun initialize()
    suspend fun getMuseums(): List<MuseumEntity>
    suspend fun getMuseumById(museumId: Long): MuseumEntity?
}

class DefaultMuseumRepository(
    private val museumRemoteDataSource: MuseumDataSource,
) : MuseumRepository {
    private val scope = CoroutineScope(SupervisorJob())

    override fun initialize() {
        scope.launch {
            refresh()
        }
    }

    override suspend fun getMuseums() = museumRemoteDataSource.fetchMuseums()

    override suspend fun getMuseumById(museumId: Long) = museumRemoteDataSource.getMuseumsById(museumId)

    private suspend fun refresh() {
        museumRemoteDataSource.saveMuseums(
            museumRemoteDataSource.fetchMuseums()
        )
    }
}
