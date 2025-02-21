package com.ds.kmmproject.data.dataSources.implementations

import com.ds.kmmproject.data.dataSources.interfaces.MuseumDataSource
import com.ds.kmmproject.data.database.MuseumsDatabase
import com.ds.kmmproject.data.models.MuseumEntity

class MuseumLocalDataSource(
    private val museumsDatabase: MuseumsDatabase
) : MuseumDataSource {
    override suspend fun saveMuseums(museums: List<MuseumEntity>) {
        museumsDatabase.getDao().insert(museums)
    }

    override suspend fun getMuseumsById(museumId: Long): MuseumEntity? {
        return museumsDatabase.getDao().getMuseumById(museumId)
    }

    override suspend fun fetchMuseums(): List<MuseumEntity> = museumsDatabase.getDao().getAll()
}