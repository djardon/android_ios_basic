package com.ds.kmmproject.data.database

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(ctx: Context): MuseumsDatabase {
    return Room.databaseBuilder(ctx, MuseumsDatabase::class.java, "ds_database.db")
        .fallbackToDestructiveMigration(true)
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}