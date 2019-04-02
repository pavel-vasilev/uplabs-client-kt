package com.pvasilev.uplabs

import android.app.Application
import androidx.emoji.bundled.BundledEmojiCompatConfig
import androidx.emoji.text.EmojiCompat

class EmojiInitializer : AppInitializer {
    override fun init(app: Application) {
        val config = BundledEmojiCompatConfig(app)
        EmojiCompat.init(config)
    }
}