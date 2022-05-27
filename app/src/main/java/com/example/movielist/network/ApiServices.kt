package com.example.movielist.network

import com.example.movielist.model.ShowDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("search/shows")
    suspend fun getShowDetails(
        @Query("q") name: String
    ): Response<List<ShowDetails>>
}