package com.pvasilev.uplabs.profile

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.uplabs.BaseMvRxViewModelFactory
import com.pvasilev.uplabs.network.UserService
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ru.terrakok.cicerone.Router

class ProfileViewModel @AssistedInject constructor(
    @Assisted initialState: ProfileState,
    private val router: Router,
    private val userService: UserService
) : BaseMvRxViewModel<ProfileState>(initialState) {
    init {
        fetchNextPage()
    }

    fun fetchNextPage() {
        withState { state ->
            userService.getPosts(state.nickname, state.posts.size / POSTS_PER_PAGE + 1)
                .execute { copy(request = it, posts = posts + (it() ?: emptyList())) }
        }
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<ProfileState, ProfileViewModel>

    companion object : MvRxViewModelFactory<ProfileViewModel, ProfileState> {
        private const val POSTS_PER_PAGE = 12

        override fun create(viewModelContext: ViewModelContext, state: ProfileState): ProfileViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<ProfileFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}