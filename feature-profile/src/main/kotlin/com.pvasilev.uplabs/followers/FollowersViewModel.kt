package com.pvasilev.uplabs.followers

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.uplabs.BaseMvRxViewModelFactory
import com.pvasilev.uplabs.models.User
import com.pvasilev.uplabs.network.services.UserService
import com.pvasilev.uplabs.profile.ProfileScreen
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ru.terrakok.cicerone.Router

class FollowersViewModel @AssistedInject constructor(
    @Assisted initialState: FollowersState,
    private val router: Router,
    private val userService: UserService
) : BaseMvRxViewModel<FollowersState>(initialState) {
    init {
        fetchNextPage()
    }

    fun fetchNextPage() {
        withState { state ->
            userService.getFollowers(state.nickname, state.users.size / USERS_PER_PAGE + 1)
                .execute { copy(request = it, users = users + (it() ?: emptyList())) }
        }
    }

    fun onProfileClicked(user: User) {
        router.navigateTo(ProfileScreen(user.nickname))
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<FollowersState, FollowersViewModel>

    companion object : MvRxViewModelFactory<FollowersViewModel, FollowersState> {
        private const val USERS_PER_PAGE = 12

        override fun create(viewModelContext: ViewModelContext, state: FollowersState): FollowersViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<FollowersFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}