package com.pvasilev.uplabs.followers

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.pvasilev.uplabs.network.UserService

class FollowersViewModel(
    initialState: FollowersState,
    private val userService: UserService
) : BaseMvRxViewModel<FollowersState>(initialState) {
    init {
        fetchNextPage()
    }

    private fun fetchNextPage() {
        withState { state ->
            userService.getFollowers(state.nickname, state.users.size / USERS_PER_PAGE + 1)
                .execute { copy(request = it, users = users + (it() ?: emptyList())) }
        }
    }

    companion object : MvRxViewModelFactory<FollowersViewModel, FollowersState> {
        private const val USERS_PER_PAGE = 12
    }
}