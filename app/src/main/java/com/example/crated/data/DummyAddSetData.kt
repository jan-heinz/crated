package com.example.crated.data

data class AddSetFormData(
    val title: String = "",
    val artist: String = "",
    val sourceUrl: String = "",
    val sourcePlatform: String = "",
    val year: String = "",
    val length: String = "",
    val eventName: String = "",
    val date: String = "",
    val tags: String = "",
    val averageRating: String = "",
    val reviewCount: String = "0",
    val savedCount: String = "0",
    val notes: String = "",
)

val dummyAddSetFormData = AddSetFormData(
    title = "Basement Session 04",
    artist = "Nia Archives",
    sourceUrl = "https://www.youtube.com/watch?v=example",
    sourcePlatform = "YouTube",
    year = "2025",
    length = "54 min",
    eventName = "",
    date = "",
    tags = "jungle, live, high energy",
    averageRating = "",
    reviewCount = "0",
    savedCount = "0",
    notes = "",
)
