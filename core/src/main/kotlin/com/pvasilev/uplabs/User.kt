package com.pvasilev.uplabs

data class User(
    val id: Int,
    val nickname: String,
    val fullName: String,
    val headline: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int
)