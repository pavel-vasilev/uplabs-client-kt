package com.pvasilev.uplabs.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.uplabs.*
import kotlinx.android.synthetic.main.fragment_base.*

class FollowingFragment : BaseMvRxFragment<FollowingState, FollowingViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<FollowingState, FollowingViewModel>
        get() = TODO()

    private val viewModel: FollowingViewModel by fragmentViewModel()

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