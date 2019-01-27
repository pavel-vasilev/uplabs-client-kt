package com.pvasilev.uplabs

sealed class Lce<T> {
    class Loading<T> : Lce<T>()
    class Content<T>(val value: T) : Lce<T>()
    class Error<T>(val error: Throwable) : Lce<T>()
}