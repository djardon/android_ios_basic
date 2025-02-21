package com.ds.dscomposeapp.domain.usecases

import com.ds.dscomposeapp.data.repositories.MuseumRepository
import com.ds.dscomposeapp.domain.mappers.MuseumEntityMapper
import com.ds.dscomposeapp.domain.models.Museum

interface GetMuseumUseCase {
    suspend fun execute(museumId: Long): Museum?
}

class DefaultGetMuseumUseCase(
    private val museumRepository: MuseumRepository,
    private val museumMapper: MuseumEntityMapper
) : GetMuseumUseCase {
    override suspend fun execute(museumId: Long): Museum? {
        return museumRepository.getMuseumById(museumId)?.let {
            museumMapper.map(it)
        }
    }
}