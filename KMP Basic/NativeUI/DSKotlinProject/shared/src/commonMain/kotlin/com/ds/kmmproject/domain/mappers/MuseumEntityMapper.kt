package com.ds.kmmproject.domain.mappers

import com.ds.kmmproject.data.models.MuseumEntity
import com.ds.kmmproject.domain.models.Museum

interface MuseumEntityMapper {
    fun map(dto: List<MuseumEntity>): List<Museum>
    fun map(dto: MuseumEntity): Museum
}

class DefaultMuseumEntityMapper : MuseumEntityMapper {
    override fun map(dto: List<MuseumEntity>): List<Museum> {
        return dto.map { map(it) }
    }

    override fun map(dto: MuseumEntity): Museum {
        return Museum(
            id = dto.id,
            museumId = dto.objectID,
            title = dto.title,
            artist = dto.artistDisplayName,
            medium = dto.medium,
            dimensions = dto.dimensions,
            url = dto.objectURL,
            date = dto.objectDate,
            imageUrl = dto.primaryImage,
            imageSmallUrl = dto.primaryImageSmall,
            repository = dto.repository,
            department = dto.department,
            creditLine = dto.creditLine,
        )
    }
}