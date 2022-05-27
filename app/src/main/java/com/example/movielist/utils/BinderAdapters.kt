package com.example.movielist.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.movielist.model.Rating

class BinderAdapters {
    companion object {
        @BindingAdapter("genreList")
        @JvmStatic
        fun TextView.genreList(list: List<String>?) {
            text = list?.joinToString(", ") ?: ""
        }

        @BindingAdapter("rating")
        @JvmStatic
        fun TextView.rating(rating: Rating?) {
            text = rating?.average?.let { String.format("Rating: %s", rating.average) }
        }
    }
}