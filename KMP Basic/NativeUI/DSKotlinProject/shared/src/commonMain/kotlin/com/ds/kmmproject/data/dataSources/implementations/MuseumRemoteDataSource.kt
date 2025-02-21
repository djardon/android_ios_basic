package com.ds.kmmproject.data.dataSources.implementations

import com.ds.kmmproject.data.api.MuseumApi
import com.ds.kmmproject.data.dataSources.interfaces.MuseumDataSource
import com.ds.kmmproject.data.models.MuseumEntity

class MuseumRemoteDataSource(
    private val museumApi: MuseumApi
) : MuseumDataSource {
    private var storedObjects = mutableListOf<MuseumEntity>()

    override suspend fun saveMuseums(museums: List<MuseumEntity>) {
        storedObjects.addAll(museums)
    }

    override suspend fun getMuseumsById(museumId: Long): MuseumEntity? {
        return storedObjects.firstOrNull {
            it.id == museumId
        }
    }

    override suspend fun fetchMuseums(): List<MuseumEntity> {
        saveMuseums(museumApi.getData())
        return storedObjects
    }
}