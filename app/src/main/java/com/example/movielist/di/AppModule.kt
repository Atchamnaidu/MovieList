package com.example.movielist.di

import android.content.Context
import com.example.movielist.MoviesApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun providesAppContext(application: MoviesApplication): Context
}