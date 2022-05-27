package com.example.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielist.model.ShowDetails
import com.example.movielist.repository.ShowDetailsRepository
import com.example.movielist.utils.Response
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val showDetailsRepository: ShowDetailsRepository) :
    ViewModel() {

    val showDetails: LiveData<Response<List<ShowDetails>>>
        get() = showDetailsRepository.showDetails

    fun getShowDetails(showName: String) {
        viewModelScope.launch {
            showDetailsRepository.getShowDetails(showName)
        }
    }
}