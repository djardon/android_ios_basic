package com.ds.kmmproject.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ds.kmmproject.data.models.MuseumEntity

@Dao
interface MuseumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: MuseumEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: List<MuseumEntity>)

    @Query("SELECT count(*) FROM MuseumEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM MuseumEntity")
    suspend fun getAll(): List<MuseumEntity>

    @Query("SELECT * FROM MuseumEntity WHERE id = :museumId")
    suspend fun getMuseumById(museumId: Long): MuseumEntity?
}