package com.pvasilev.uplabs.followers

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.User

data class FollowersState(
    val nickname: String,
    val users: List<User> = emptyList(),
    val request: Async<List<User>> = Uninitialized
) : MvRxState {
    constructor(args: FollowersArgs) : this(args.nickname)
}