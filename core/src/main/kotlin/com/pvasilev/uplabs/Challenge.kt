package com.pvasilev.uplabs

data class Challenge(
    val id: Int,
    val name: String,
    val tagline: String,
    val challengers: Int,
    val winner: User,
    val posts: List<Post>
)