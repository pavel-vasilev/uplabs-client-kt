package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

interface BaseMvRxViewModelFactory<S : MvRxState, V : BaseMvRxViewModel<S>> {
    fun create(initialState: S): V
}