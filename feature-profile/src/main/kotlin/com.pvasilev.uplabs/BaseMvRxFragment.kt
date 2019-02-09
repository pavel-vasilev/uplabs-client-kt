package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class BaseMvRxFragment<S : MvRxState, V : BaseMvRxViewModel<S>> : BaseMvRxFragment() {
    abstract val viewModelFactory: BaseMvRxViewModelFactory<S, V>
}