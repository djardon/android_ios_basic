package com.ds.kmmproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ds.kmmproject.data.database.dao.MuseumDao
import com.ds.kmmproject.data.models.MuseumEntity

// https://issuetracker.google.com/issues/342905180
interface DB {
    fun clearAllTables(): Unit {}
}

@Database(entities = [MuseumEntity::class], version = 1)
abstract class MuseumsDatabase : RoomDatabase(), DB {
    abstract fun getDao(): MuseumDao
    override fun clearAllTables(): Unit {}
}

