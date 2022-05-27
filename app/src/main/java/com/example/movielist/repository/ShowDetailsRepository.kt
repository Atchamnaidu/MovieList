package com.example.movielist.repository

import androidx.lifecycle.LiveData
import com.example.movielist.model.ShowDetails
import com.example.movielist.utils.Response

interface ShowDetailsRepository {
    val showDetails: LiveData<Response<List<ShowDetails>>>
    suspend fun getShowDetails(showName: String)
}