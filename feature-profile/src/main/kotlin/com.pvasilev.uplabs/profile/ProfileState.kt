package com.pvasilev.uplabs.profile

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.Post

data class ProfileState(
    val nickname: String,
    val posts: List<Post> = emptyList(),
    val request: Async<List<Post>> = Uninitialized
) : MvRxState {
    constructor(args: ProfileArgs) : this(args.nickname)
}