package com.pvasilev.uplabs

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.Post

data class SearchState(
    val query: String = "",
    val posts: List<Post> = emptyList(),
    val request: Async<List<Post>> = Uninitialized
) : MvRxState