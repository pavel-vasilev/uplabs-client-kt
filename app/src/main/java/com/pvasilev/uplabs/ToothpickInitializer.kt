package com.pvasilev.uplabs

import android.app.Application
import toothpick.Toothpick
import toothpick.configuration.Configuration

class ToothpickInitializer : AppInitializer {
    override fun init(app: Application) {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction())
        }
        Toothpick.openScope(app)
    }
}