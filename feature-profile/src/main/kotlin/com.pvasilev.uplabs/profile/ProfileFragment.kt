package com.pvasilev.uplabs.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.uplabs.*
import kotlinx.android.synthetic.main.fragment_base.*

class ProfileFragment : BaseMvRxFragment<ProfileState, ProfileViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<ProfileState, ProfileViewModel>
        get() = TODO()

    private val viewModel: ProfileViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.buildModelsWith { controller ->
            withState(viewModel) { state ->
                for (post in state.posts) {
                    controller.postPreview {
                        id(post.id)
                        preview(post.previewUrl)
                        title(post.title)
                        views(post.views)
                        comments(post.comments)
                        downloads(post.downloads)
                        avatar(post.submitter.avatarUrl)
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