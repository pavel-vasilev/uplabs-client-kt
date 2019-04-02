package com.pvasilev.uplabs

import android.app.Application

interface AppInitializer {
    fun init(app: Application)
}