package com.ds.dscomposeapp.domain.usecases

import com.ds.dscomposeapp.data.repositories.MuseumRepository
import com.ds.dscomposeapp.domain.mappers.MuseumEntityMapper
import com.ds.dscomposeapp.domain.models.Museum

interface GetMuseumsUseCase {
    suspend fun execute(): List<Museum>
}

class DefaultGetMuseumsUseCase(
    private val museumRepository: MuseumRepository,
    private val museumMapper: MuseumEntityMapper
) : GetMuseumsUseCase {
    override suspend fun execute(): List<Museum> {
        return museumRepository.getMuseums().map { museumMapper.map(it) }
    }
}