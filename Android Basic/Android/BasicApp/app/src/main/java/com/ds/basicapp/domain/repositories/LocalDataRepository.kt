package com.ds.basicapp.domain.repositories

import android.content.Context
import com.ds.basicapp.R
import com.ds.basicapp.domain.models.Alignment
import com.ds.basicapp.domain.models.Characters
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException


interface LocalDataRepository {
    var characters: Characters
    fun initSampleData(): Flow<Characters>
    fun heroes(): Flow<Characters>
    fun villains(): Flow<Characters>
}

class LocalDataRepositoryImpl(private val context: Context): LocalDataRepository {
    override var characters: Characters = arrayOf()

    override fun initSampleData(): Flow<Characters> = flow {
        try {
            if (characters.isEmpty()) {
                // Open the JSON file
                val inputStream = context.resources.openRawResource(R.raw.heroes)

                // Read the contents of the file into a byte array
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                inputStream.close()

                // Convert the byte array to a string
                val json = String(buffer, Charsets.UTF_8)

                // Create a Gson object
                // Parse the JSON string into your desired Kotlin object
                characters = Gson().fromJson(json, Characters::class.java)

                // Return values
                emit(characters)
            } else {
                emit(characters)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)

    override fun heroes(): Flow<Characters> = flow {
        try {
            if (characters.isEmpty()) {
                // Open the JSON file
                val inputStream = context.resources.openRawResource(R.raw.heroes)

                // Read the contents of the file into a byte array
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                inputStream.close()

                // Convert the byte array to a string
                val json = String(buffer, Charsets.UTF_8)

                // Create a Gson object
                // Parse the JSON string into your desired Kotlin object
                characters = Gson().fromJson(json, Characters::class.java)

                // Return values
                emit(characters.filter { it.biography.alignment == Alignment.good }.toTypedArray())
            } else {
                emit(characters.filter { it.biography.alignment == Alignment.good }.toTypedArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)

    override fun villains(): Flow<Characters> = flow {
        try {
            if (characters.isEmpty()) {
                // Open the JSON file
                val inputStream = context.resources.openRawResource(R.raw.heroes)

                // Read the contents of the file into a byte array
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                inputStream.close()

                // Convert the byte array to a string
                val json = String(buffer, Charsets.UTF_8)

                // Create a Gson object
                // Parse the JSON string into your desired Kotlin object
                characters = Gson().fromJson(json, Characters::class.java)

                // Return values
                emit(characters.filter { it.biography.alignment == Alignment.bad }.toTypedArray())
            } else {
                emit(characters.filter { it.biography.alignment == Alignment.bad }.toTypedArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)
}