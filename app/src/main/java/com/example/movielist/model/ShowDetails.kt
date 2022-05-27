package com.example.movielist.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "showdetails")
data class ShowDetails(
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
    val score: Double? =0.0,
    @Embedded
    val show: Show
)