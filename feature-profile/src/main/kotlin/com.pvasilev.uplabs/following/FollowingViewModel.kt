package com.pvasilev.uplabs.following

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.pvasilev.uplabs.network.UserService

class FollowingViewModel(
    initialState: FollowingState,
    private val userService: UserService
) : BaseMvRxViewModel<FollowingState>(initialState) {
    init {
        fetchNextPage()
    }

    private fun fetchNextPage() {
        withState { state ->
            userService.getFollowing(state.nickname, state.users.size / USERS_PER_PAGE + 1)
                .execute { copy(request = it, users = users + (it() ?: emptyList())) }
        }
    }

    companion object : MvRxViewModelFactory<FollowingViewModel, FollowingState> {
        private const val USERS_PER_PAGE = 12
    }
}