package graphql

import com.apollographql.apollo3.ApolloClient

fun initApollo(){
    val apolloClient = ApolloClient.Builder().serverUrl("https://graphql.anilist.co").build()
}
