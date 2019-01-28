package com.pvasilev.uplabs.models

data class Post(
    val id: Int,
    val name: String,
    val description: Int,
    val previewUrl: String,
    val label: String,
    val category: String,
    val submitter: User,
    val views: Int,
    val comments: Int,
    val downloads: Int,
    val votes: Int,
    val medal: Medal?
)