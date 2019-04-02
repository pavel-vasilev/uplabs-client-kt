package com.pvasilev.uplabs

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SearchScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SearchFragment()
    }
}