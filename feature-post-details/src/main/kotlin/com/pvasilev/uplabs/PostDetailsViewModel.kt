package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.uplabs.network.services.PostService
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostDetailsViewModel @AssistedInject constructor(
    @Assisted initialState: PostDetailsState,
    private val postService: PostService
) : BaseMvRxViewModel<PostDetailsState>(initialState) {

    init {
        withState { state ->
            postService.getPost(state.link)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .execute { copy(post = it) }
        }
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<PostDetailsState, PostDetailsViewModel>

    companion object : MvRxViewModelFactory<PostDetailsViewModel, PostDetailsState> {
        override fun create(viewModelContext: ViewModelContext, state: PostDetailsState): PostDetailsViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<PostDetailsFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}