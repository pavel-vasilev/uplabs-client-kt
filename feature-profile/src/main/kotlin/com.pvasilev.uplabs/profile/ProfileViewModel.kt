package com.pvasilev.uplabs.profile

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.pvasilev.uplabs.network.UserService

class ProfileViewModel(
    initialState: ProfileState,
    private val userService: UserService
) : BaseMvRxViewModel<ProfileState>(initialState) {
    init {
        fetchNextPage()
    }

    private fun fetchNextPage() {
        withState { state ->
            userService.getPosts(state.nickname, state.posts.size / POSTS_PER_PAGE + 1)
                .execute { copy(request = it, posts = posts + (it() ?: emptyList())) }
        }
    }

    companion object : MvRxViewModelFactory<ProfileViewModel, ProfileState> {
        private const val POSTS_PER_PAGE = 12
    }
}