package data

import com.orisu179.anilist.AnimeQuery
import com.orisu179.anilist.UserAnimeListQuery
import domain.DetailedAnime
import domain.SimpleAnime

fun AnimeQuery.Media.toDetailedAnime() : DetailedAnime {
    return DetailedAnime(
        id = id,
        enTitle = title?.english,
        nativeTitle = title?.native,
        romajiTitle = title?.romaji,
        score = averageScore,
        releaseDate = seasonYear.toString(),
        coverImageUrl = coverImage?.large,
        description = description,
        status = status,
        genres = genres,
    )
}

fun UserAnimeListQuery.MediaList.toSimpleAnime() : SimpleAnime {
    return SimpleAnime(
        id = media?.id,
        title = media?.title?.english,
        score = media?.averageScore,
        releaseDate = media?.seasonYear.toString(),
        coverImageUrl = media?.coverImage?.medium,
    )
}