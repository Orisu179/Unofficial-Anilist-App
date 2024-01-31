package domain

import com.apollographql.apollo3.api.Optional

interface AnilistClient {
    suspend fun getSeasonalAnimeList(season: Season, year: Int): List<SimpleAnime>
    suspend fun getUserAnimeList(userId: Int): List<SimpleAnime>
    suspend fun getAnimeById(id: Int): DetailedAnime?
    suspend fun getUserDetails(userId: Int): Profile
}