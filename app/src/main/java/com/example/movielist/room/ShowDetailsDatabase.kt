package com.example.movielist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movielist.model.ShowDetails
import com.example.movielist.utils.Converters

@Database(entities = [ShowDetails::class], version = 1)
@TypeConverters(Converters::class)
abstract class ShowDetailsDatabase : RoomDatabase() {
    abstract fun getShowDetailsDao(): ShowDetailsDao
}