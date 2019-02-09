package com.pvasilev.uplabs.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MvRx
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ProfileScreen(private val nickname: String) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return ProfileFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MvRx.KEY_ARG, ProfileArgs(nickname))
            }
        }
    }
}