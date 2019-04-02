package com.pvasilev.uplabs

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class ThreeTenInitializer : AppInitializer {
    override fun init(app: Application) {
        AndroidThreeTen.init(app)
    }
}