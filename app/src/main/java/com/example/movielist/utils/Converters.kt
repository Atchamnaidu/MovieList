package com.example.movielist.utils

import androidx.room.TypeConverter
import com.example.movielist.model.*
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    @TypeConverter
    fun fromString(value: String?): List<String?>? {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }


    @TypeConverter
    fun countryTypeToJson(value: Country?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToCountryType(value: String): Country =
        Gson().fromJson(value, Country::class.java)

    @TypeConverter
    fun externalTypeToJson(value: Externals?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToExternalType(value: String): Externals =
        Gson().fromJson(value, Externals::class.java)

    @TypeConverter
    fun imageTypeToJson(value: Image?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToImageType(value: String): Image =
        Gson().fromJson(value, Image::class.java)

    @TypeConverter
    fun linksTypeToJson(value: Links?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToLinksType(value: String): Links =
        Gson().fromJson(value, Links::class.java)

    @TypeConverter
    fun networkTypeToJson(value: Network?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToNetworkType(value: String): Network =
        Gson().fromJson(value, Network::class.java)

    @TypeConverter
    fun prevEpisodeTypeToJson(value: Previousepisode?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToPreviousEpisodeType(value: String): Previousepisode =
        Gson().fromJson(value, Previousepisode::class.java)

    @TypeConverter
    fun ratingTypeToJson(value: Rating?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToRatingType(value: String): Rating =
        Gson().fromJson(value, Rating::class.java)

    @TypeConverter
    fun scheduleTypeToJson(value: Schedule?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToScheduleType(value: String): Schedule =
        Gson().fromJson(value, Schedule::class.java)

    @TypeConverter
    fun selfTypeToJson(value: Self?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToSelfType(value: String): Self =
        Gson().fromJson(value, Self::class.java)

    @TypeConverter
    fun showTypeToJson(value: Show?): String? = Gson().toJson(value)

    @TypeConverter
    fun jsonToShowType(value: String): Show =
        Gson().fromJson(value, Show::class.java)
}