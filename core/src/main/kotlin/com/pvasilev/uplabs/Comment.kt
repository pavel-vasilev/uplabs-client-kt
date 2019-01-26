package com.pvasilev.uplabs

data class Comment(
    val id: Int,
    val body: String,
    val user: User,
    val likes: Int
)