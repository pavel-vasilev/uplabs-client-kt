package com.pvasilev.uplabs.followers

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MvRx
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FollowersScreen(private val nickname: String) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return FollowersFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MvRx.KEY_ARG, FollowersArgs(nickname))
            }
        }
    }
}