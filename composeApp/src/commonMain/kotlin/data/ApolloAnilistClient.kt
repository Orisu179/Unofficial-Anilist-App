package data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.orisu179.anilist.AnimeQuery
import com.orisu179.anilist.UserAnimeListQuery
import domain.*

class ApolloAnilistClient(
    private val apolloClient: ApolloClient
): AnilistClient {
    override suspend fun getSeasonalAnimeList(season: Season, year: Int): List<SimpleAnime> {
        TODO()
    }

    override suspend fun getUserAnimeList(userId: Int): List<SimpleAnime?>? {
        return apolloClient
            .query(UserAnimeListQuery(userId = userId))
            .execute()
            .data
            ?.Page
            ?.mediaList
            ?.map { it?.toSimpleAnime() }
    }

    override suspend fun getAnimeById(id: Int): DetailedAnime? {
        return apolloClient
            .query(AnimeQuery(id))
            .execute()
            .data
            ?.Media
            ?.toDetailedAnime()
    }

    override suspend fun getUserDetails(userId: Int): Profile {
        TODO("Not yet implemented")
    }
}