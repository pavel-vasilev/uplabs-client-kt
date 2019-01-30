package com.pvasilev.uplabs.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.pvasilev.uplabs.R
import kotlinx.android.synthetic.main.fragment_base.*

class ProfileFragment : BaseMvRxFragment() {
    private val viewModel: ProfileViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_base, container, false)

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }
}