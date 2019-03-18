package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PostDetailsViewModel @AssistedInject constructor(
    @Assisted initialState: PostDetailsState
) : BaseMvRxViewModel<PostDetailsState>(initialState) {

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