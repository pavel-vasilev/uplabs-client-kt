package com.pvasilev.uplabs

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.Comment
import com.pvasilev.uplabs.models.Post

data class PostDetailsState(
    val link: String,
    val post: Async<Post> = Uninitialized,
    val comments: Async<List<Comment>> = Uninitialized
) : MvRxState {
    constructor(args: PostDetailsArgs) : this(args.link)
}