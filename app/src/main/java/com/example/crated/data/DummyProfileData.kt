package com.example.crated.data

data class ProfileListItemData(
    val action: String,
    val title: String,
    val detail: String,
)

val dummyActivityItems = listOf(
    ProfileListItemData(
        action = "Rated a set",
        title = "Boiler Room London",
        detail = "Fred again.. - Rated: 5.0 / 5"
    ),
    ProfileListItemData(
        action = "Created a crate",
        title = "Fresh Finds",
        detail = "A crate for newly uploaded sets"
    ),
    ProfileListItemData(
        action = "Saved a set",
        title = "Live at Lot Radio",
        detail = "TSHA - freshly uploaded"
    ),
    ProfileListItemData(
        action = "Reviewed a set",
        title = "Warehouse Recording 07",
        detail = "Unknown Artist - no known year"
    ),
)

val dummyReviewItems = listOf(
    ProfileListItemData(
        action = "4.8 / 5",
        title = "Boiler Room London",
        detail = "Crowd energy is unreal."
    ),
    ProfileListItemData(
        action = "3.9 / 5",
        title = "Warehouse Recording 07",
        detail = "Raw and mysterious, but the audio is rough."
    ),
    ProfileListItemData(
        action = "4.5 / 5",
        title = "Lost Village",
        detail = "Warm, bright, and easy to replay."
    ),
)

val dummyCrateItems = listOf(
    ProfileListItemData(
        action = "Public crate",
        title = "Fresh Finds",
        detail = "12 saved sets"
    ),
    ProfileListItemData(
        action = "Public crate",
        title = "Festival Favorites",
        detail = "24 saved sets"
    ),
    ProfileListItemData(
        action = "Private crate",
        title = "Late Night House",
        detail = "9 saved sets"
    ),
    ProfileListItemData(
        action = "Public crate",
        title = "Mystery Uploads",
        detail = "7 saved sets"
    ),
)
