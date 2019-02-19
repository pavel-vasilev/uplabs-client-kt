package com.pvasilev.uplabs.models

sealed class License {
    object Free : License()
    data class Commercial(val price: Float) : License()
}