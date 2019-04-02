package com.pvasilev.uplabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel

class SearchFragment : BaseMvRxFragment<SearchState, SearchViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<SearchState, SearchViewModel>
        get() = TODO()

    private val viewModel: SearchViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_base, container, false)

    override fun invalidate() {
    }
}