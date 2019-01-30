package com.pvasilev.uplabs.following

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.User

data class FollowingState(
    val nickname: String,
    val users: List<User> = emptyList(),
    val request: Async<List<User>> = Uninitialized
) : MvRxState {
    constructor(args: FollowingArgs) : this(args.nickname)
}