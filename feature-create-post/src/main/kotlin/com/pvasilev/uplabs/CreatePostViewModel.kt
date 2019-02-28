package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.uplabs.network.UploadService
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class CreatePostViewModel @AssistedInject constructor(
    @Assisted initialState: CreatePostState,
    private val uploadService: UploadService
) : BaseMvRxViewModel<CreatePostState>(initialState) {
    fun onContinueClicked() {
        setState { copy(currentStep = currentStep + 1) }
    }

    fun onCancelClicked() {
        setState { copy(currentStep = currentStep - 1) }
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<CreatePostState, CreatePostViewModel>

    companion object : MvRxViewModelFactory<CreatePostViewModel, CreatePostState> {
        override fun create(viewModelContext: ViewModelContext, state: CreatePostState): CreatePostViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<CreatePostFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}