package com.example.movielist.modules

import androidx.lifecycle.ViewModelProvider
import com.example.movielist.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Singleton
    @Binds
    abstract fun providesViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}