package com.ds.kmmproject.data.database

// Make sure you eventually have this imported properly
// The package prefix should be the same as your database declared above
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): MuseumsDatabase {
    val dbFile = "${NSHomeDirectory()}/ds_database.db"
    return Room.databaseBuilder<MuseumsDatabase>(
        name = dbFile,
        factory = { MuseumsDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}