package com.example.crated.model

data class Set(
    val id: String,
    val title: String,
    val artist: String,
    val sourceUrl: String,
    val sourcePlatform: String,
    val year: String?, // optional
    val length: String?, // optional
    val eventName: String?, // optional
    val date: String?, // optional
    val tags: List<String> = emptyList(),
    val averageRating: Float?, // optional
    val reviewCount: Int = 0,
    val savedCount: Int = 0,
    val notes: String?, // optional
)
