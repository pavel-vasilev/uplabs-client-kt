package com.pvasilev.uplabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel

class PostDetailsFragment : BaseMvRxFragment<PostDetailsState, PostDetailsViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<PostDetailsState, PostDetailsViewModel>
        get() = TODO()

    private val viewModel: PostDetailsViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile_details, container, false)

    override fun invalidate() {
        TODO()
    }
}