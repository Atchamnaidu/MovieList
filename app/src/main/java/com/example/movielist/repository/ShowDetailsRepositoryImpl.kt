package com.example.movielist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movielist.model.ShowDetails
import com.example.movielist.network.ApiServices
import com.example.movielist.room.ShowDetailsDatabase
import com.example.movielist.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ShowDetailsRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices,
    private val showDetailsDatabase: ShowDetailsDatabase
) :
    ShowDetailsRepository {
    private var _showDetails = MutableLiveData<Response<List<ShowDetails>>>()
    override val showDetails: LiveData<Response<List<ShowDetails>>>
        get() = _showDetails

    override suspend fun getShowDetails(showName: String) {
        withContext(Dispatchers.IO) {
            val response = apiServices.getShowDetails(showName)
            if (response.isSuccessful && response.body() != null) {
                showDetailsDatabase.getShowDetailsDao().insert(response.body()!!)
                withContext(Dispatchers.Main) {
                    _showDetails.value = Response.Success(response.body()!!)
                }
            }
        }
    }
}