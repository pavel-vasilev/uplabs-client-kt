package com.pvasilev.uplabs.following

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MvRx
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FollowingScreen(private val nickname: String) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return FollowingFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MvRx.KEY_ARG, FollowingArgs(nickname))
            }
        }
    }
}