package com.ds.kmmproject.domain.models

data class Museum(
    val id: Long,
    val museumId: Int,
    val title: String,
    val artist: String,
    val medium: String,
    val dimensions: String,
    val url: String,
    val date: String,
    val imageUrl: String,
    val imageSmallUrl: String,
    val repository: String,
    val department: String,
    val creditLine: String
)