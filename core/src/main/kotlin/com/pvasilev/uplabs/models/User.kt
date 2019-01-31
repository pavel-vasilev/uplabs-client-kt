package com.pvasilev.uplabs.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: Int,
    val nickname: String,
    @Json(name = "full_name") val fullName: String,
    val headline: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "followers_count") val followers: Int,
    @Json(name = "following_count") val following: Int
)