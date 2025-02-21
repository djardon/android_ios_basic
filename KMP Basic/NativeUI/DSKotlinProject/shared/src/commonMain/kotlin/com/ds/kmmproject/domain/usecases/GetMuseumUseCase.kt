package com.ds.kmmproject.domain.usecases

import com.ds.kmmproject.data.repositories.MuseumRepository
import com.ds.kmmproject.domain.mappers.MuseumEntityMapper
import com.ds.kmmproject.domain.models.Museum

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