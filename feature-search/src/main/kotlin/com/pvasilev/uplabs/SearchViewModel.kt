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

class SearchViewModel @AssistedInject constructor(
    @Assisted initialState: SearchState,
    private val postService: PostService
) : BaseMvRxViewModel<SearchState>(initialState) {

    init {
        withState { state ->
            postService.search(state.query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .execute { copy(request = it, posts = posts + (it() ?: emptyList())) }
        }
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<SearchState, SearchViewModel>

    companion object : MvRxViewModelFactory<SearchViewModel, SearchState> {
        override fun create(viewModelContext: ViewModelContext, state: SearchState): SearchViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<SearchFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}