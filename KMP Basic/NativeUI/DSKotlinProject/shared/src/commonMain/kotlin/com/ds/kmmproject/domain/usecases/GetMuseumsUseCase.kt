package com.ds.kmmproject.domain.usecases

import com.ds.kmmproject.data.repositories.MuseumRepository
import com.ds.kmmproject.domain.mappers.MuseumEntityMapper
import com.ds.kmmproject.domain.models.Museum

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