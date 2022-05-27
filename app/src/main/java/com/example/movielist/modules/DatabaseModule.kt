package com.example.movielist.modules

import android.content.Context
import androidx.room.Room
import com.example.movielist.room.ShowDetailsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(context: Context): ShowDetailsDatabase {
        return Room.databaseBuilder(context, ShowDetailsDatabase::class.java, "ShowsDB")
            .build()
    }
}