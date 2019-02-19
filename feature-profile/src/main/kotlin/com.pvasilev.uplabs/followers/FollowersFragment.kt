package com.pvasilev.uplabs.followers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.uplabs.*
import kotlinx.android.synthetic.main.fragment_base.*

class FollowersFragment : BaseMvRxFragment<FollowersState, FollowersViewModel>() {
    override val viewModelFactory: FollowersViewModel.Factory = TODO()

    private val viewModel: FollowersViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.buildModelsWith { controller ->
            withState(viewModel) { state ->
                for (user in state.users) {
                    controller.oneLineAvatar {
                        id(user.id)
                        title(user.fullName)
                        avatar(user.avatarUrl)
                        onClick {
                            viewModel.onProfileClicked(user)
                        }
                    }
                }
            }
        }
        recyclerView.addOnScrollListener(EndlessScrollListener(viewModel::fetchNextPage))
    }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }
}