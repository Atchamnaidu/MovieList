package com.example.movielist.modules

import androidx.lifecycle.ViewModel
import com.example.movielist.repository.ShowDetailsRepository
import com.example.movielist.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class MainViewModelModule {
    @Provides
    @IntoMap
    @ClassKey(MainViewModel::class)
    fun providesMainViewModel(repository: ShowDetailsRepository): ViewModel {
        return MainViewModel(repository)
    }
}