package data

import kotlin.time.TimeSource

data class Item(
    val name: String,
    val animeList: List<String>,
    val time: TimeSource
)