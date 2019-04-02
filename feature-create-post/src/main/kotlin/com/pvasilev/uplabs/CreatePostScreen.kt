package com.pvasilev.uplabs

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CreatePostScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return CreatePostFragment()
    }
}