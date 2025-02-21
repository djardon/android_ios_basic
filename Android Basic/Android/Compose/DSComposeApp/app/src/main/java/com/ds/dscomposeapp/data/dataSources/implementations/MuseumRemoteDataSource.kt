package com.ds.dscomposeapp.data.dataSources.implementations

import com.ds.dscomposeapp.data.api.MuseumApi
import com.ds.dscomposeapp.data.dataSources.interfaces.MuseumDataSource
import com.ds.dscomposeapp.data.models.MuseumEntity

class MuseumRemoteDataSource(
    private val museumApi: MuseumApi
) : MuseumDataSource {
    private var storedObjects = mutableListOf<MuseumEntity>()

    override suspend fun saveMuseums(museums: List<MuseumEntity>) {
        storedObjects.addAll(museums)
    }

    override suspend fun getMuseumsById(museumId: Long): MuseumEntity? {
        return storedObjects.firstOrNull {
            it.objectID.toLong() == museumId
        }
    }

    override suspend fun fetchMuseums(): List<MuseumEntity> {
        saveMuseums(museumApi.getData())
        return storedObjects
    }
}