package com.pvasilev.uplabs

import android.content.Context
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_emoji_two_line.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TwoLineEmoji(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_emoji_two_line, this)
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @TextProp
    fun subtitle(subtitle: CharSequence) {
        tv_subtitle.text = subtitle
    }

    @TextProp
    fun emoji(emoji: CharSequence) {
        tv_emoji.text = emoji
    }

    @CallbackProp
    fun onClick(callback: (() -> Unit)?) {
        setOnClickListener {
            callback?.invoke()
        }
    }
}