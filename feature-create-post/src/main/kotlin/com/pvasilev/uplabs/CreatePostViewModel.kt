package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel

class CreatePostViewModel(initialState: CreatePostState) : BaseMvRxViewModel<CreatePostState>(initialState) {
    fun onContinueClicked() {
        setState { copy(currentStep = currentStep + 1) }
    }

    fun onCancelClicked() {
        setState { copy(currentStep = currentStep - 1) }
    }
}