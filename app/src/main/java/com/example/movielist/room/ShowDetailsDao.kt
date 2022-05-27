package com.example.movielist.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movielist.model.ShowDetails

@Dao
interface ShowDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(showDetails: List<ShowDetails>)

    @Query("Select * from showdetails")
    fun getShowDetails(): LiveData<List<ShowDetails>>
}