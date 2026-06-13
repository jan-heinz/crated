package com.example.crated.data

data class ReviewSetFormData(
    val rating: Float = 0f,
    val reviewText: String = "",
    val customTags: String = "",
)

val dummyReviewSetFormData = ReviewSetFormData(
    rating = 3.5f,
    reviewText = "Great pacing and a excellent transitions. Recording quality worsens in second half.",
    customTags = "great transitions, crowd noise, replayable",
)
