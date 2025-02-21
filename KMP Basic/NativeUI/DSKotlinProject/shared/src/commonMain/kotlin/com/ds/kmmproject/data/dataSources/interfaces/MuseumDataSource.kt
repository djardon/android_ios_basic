package com.ds.kmmproject.data.dataSources.interfaces

import com.ds.kmmproject.data.models.MuseumEntity

interface MuseumDataSource {
    suspend fun fetchMuseums(): List<MuseumEntity>
    suspend fun saveMuseums(museums: List<MuseumEntity>)
    suspend fun getMuseumsById(museumId: Long): MuseumEntity?
}