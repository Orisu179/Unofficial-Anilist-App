package domain

import com.orisu179.anilist.type.MediaStatus


data class DetailedAnime(
    val id: Int,
    val enTitle: String?,
    val romajiTitle: String?,
    val nativeTitle: String?,
    val score: Int?,
    val releaseDate: String,
    val coverImageUrl: String?,
    val description: String?,
    val status: MediaStatus?,
    val genres: List<String?>?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as DetailedAnime

        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id
    }
}
