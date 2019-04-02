package com.pvasilev.uplabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MvRx
import ru.terrakok.cicerone.android.support.SupportAppScreen

class PostDetailsScreen(private val link: String) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return PostDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MvRx.KEY_ARG, PostDetailsArgs(link))
            }
        }
    }
}