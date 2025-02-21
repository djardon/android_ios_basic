package com.ds.dscomposeapp.data.dataSources.interfaces

import com.ds.dscomposeapp.data.models.MuseumEntity

interface MuseumDataSource {
    suspend fun fetchMuseums(): List<MuseumEntity>
    suspend fun saveMuseums(museums: List<MuseumEntity>)
    suspend fun getMuseumsById(museumId: Long): MuseumEntity?
}