package com.example.crated.data

import com.example.crated.model.Set

val dummySets = listOf(
    Set(
        id = "set-1",
        title = "Boiler Room London",
        artist = "Fred again..",
        sourceUrl = "https://www.youtube.com/",
        sourcePlatform = "YouTube",
        year = "2022",
        length = "58 min",
        eventName = "Boiler Room", // optional
        date = "2022", // optional
        tags = listOf("house", "garage", "live"),
        averageRating = 4.8f, // optional
        reviewCount = 284,
        savedCount = 1203,
        notes = "High-energy live set with crowd-forward transitions.", // optional
    ),
    Set(
        id = "set-2",
        title = "Live at Lot Radio",
        artist = "TSHA",
        sourceUrl = "https://www.youtube.com/",
        sourcePlatform = "YouTube",
        year = "2026",
        length = "62 min",
        eventName = "The Lot Radio", // optional
        date = "2026", // optional
        tags = listOf("fresh upload", "house", "melodic"),
        averageRating = null, // optional
        reviewCount = 0,
        savedCount = 8,
        notes = "Freshly uploaded set waiting for community reviews.", // optional
    ),
    Set(
        id = "set-3",
        title = "Warehouse Recording 07",
        artist = "Unknown Artist",
        sourceUrl = "https://www.soundcloud.com/",
        sourcePlatform = "SoundCloud",
        year = null, // optional
        length = "47 min",
        eventName = null, // optional
        date = null, // optional
        tags = listOf("techno", "raw", "unknown"),
        averageRating = 3.9f, // optional
        reviewCount = 12,
        savedCount = 64,
        notes = "Unlabeled recording with no confirmed year or event.", // optional
    ),
    Set(
        id = "set-4",
        title = "Lost Village",
        artist = "Jayda G",
        sourceUrl = "https://www.soundcloud.com/",
        sourcePlatform = "SoundCloud",
        year = "2023",
        length = "74 min",
        eventName = "Lost Village", // optional
        date = "2023", // optional
        tags = listOf("disco", "house", "feel-good"), // optional
        averageRating = 4.5f, // optional
        reviewCount = 73, // optional
        savedCount = 352, // optional
        notes = "Bright, danceable set with warm disco edits.", // optional
    ),
)
