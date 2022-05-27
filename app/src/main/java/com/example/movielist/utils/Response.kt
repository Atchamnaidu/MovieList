package com.example.movielist.utils

sealed class Response<T>(
    val data: T? = null,
    val errMsg: String? = null
) {
    class Loading<T> : Response<T>()
    class Success<T>(data: T?) : Response<T>(data = data)
    class Error<T>(errMsg: String?) : Response<T>(errMsg = errMsg)
}
