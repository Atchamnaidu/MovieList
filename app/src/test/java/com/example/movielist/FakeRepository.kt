package com.example.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movielist.model.Rating
import com.example.movielist.model.Show
import com.example.movielist.model.ShowDetails
import com.example.movielist.repository.ShowDetailsRepository
import com.example.movielist.utils.Response

class FakeRepository : ShowDetailsRepository {
    private var _showDetails = MutableLiveData<Response<List<ShowDetails>>>()
    override val showDetails: LiveData<Response<List<ShowDetails>>>
        get() = _showDetails

    override suspend fun getShowDetails(showName: String) {
        _showDetails.value = Response.Success(getData())
    }

    private fun getData(): List<ShowDetails>? {
        return listOf(
            ShowDetails(
                1,
                0.90920436,
                Show(
                    name = "Test1",
                    language = "Eng",
                    rating = Rating(0.8),
                    genres = listOf("Animation", "Comedy")
                )
            )
        )
    }
}