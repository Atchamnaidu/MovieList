package com.example.movielist.modules

import com.example.movielist.network.ApiServices
import com.example.movielist.repository.ShowDetailsRepository
import com.example.movielist.repository.ShowDetailsRepositoryImpl
import com.example.movielist.room.ShowDetailsDatabase
import dagger.Module
import dagger.Provides

@Module
class ShowsRepositoryModule {

    @Provides
    fun providesShowsRepository(
        apiServices: ApiServices,
        showDetailsDatabase: ShowDetailsDatabase
    ): ShowDetailsRepository {
        return ShowDetailsRepositoryImpl(apiServices, showDetailsDatabase)
    }
}