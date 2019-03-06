package com.pvasilev.uplabs.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    val id: Int,
    @Json(name = "name") val title: String,
    @Json(name = "description_without_html") val description: String,
    @Json(name = "preview_url") val previewUrl: String,
    @Json(name = "label_friendly_name") val label: String,
    @Json(name = "category_friendly_name") val category: String,
    @Json(name = "serialized_submitter") val submitter: User,
    @Json(name = "view_count") val views: Int,
    @Json(name = "comments_count") val comments: Int,
    @Json(name = "downloads_count") val downloads: Int,
    @Json(name = "votes_count") val votes: Int,
    val medal: Medal?
)