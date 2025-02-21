package com.ds.basicapp.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

typealias Characters = Array<Character>

// MARK: - HeroElement
data class Character (
    val id: Int,
    val name: String,
    val slug: String,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images,
): Serializable {
    var isFavorite: Boolean = false
}

// MARK: - Appearance
data class Appearance (
    val gender: Gender,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
): Serializable

enum class Gender: Serializable {
    @SerializedName("")
    undefined,
    @SerializedName("Female")
    female,
    @SerializedName("Male")
    male
}

// MARK: - Biography
data class Biography (
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String?,
    val alignment: Alignment
): Serializable

enum class Alignment: Serializable {
    bad,
    good,
    neutral
}

// MARK: - Connections
data class Connections (
    val groupAffiliation: String,
    val relatives: String
): Serializable

// MARK: - Images
data class Images (
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
): Serializable

// MARK: - Powerstats
data class Powerstats (
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
): Serializable

// MARK: - Work
data class Work (
    val occupation: String,
    val base: String
): Serializable

// MARK: - Publisher
enum class Publisher: Serializable {
    dc,
    marvel
}

