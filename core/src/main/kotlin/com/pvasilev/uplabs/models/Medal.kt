package com.pvasilev.uplabs.models

import com.squareup.moshi.Json

enum class Medal {
    @Json(name = "bronze") BRONZE,
    @Json(name = "silver") SILVER,
    @Json(name = "gold") GOLD
}