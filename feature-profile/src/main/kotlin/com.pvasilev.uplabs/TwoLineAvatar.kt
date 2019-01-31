package com.pvasilev.uplabs

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_avatar_two_line.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TwoLineAvatar(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_avatar_two_line, this)
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
    fun avatar(url: CharSequence) {
        Glide.with(context)
            .load(url)
            .into(iv_avatar)
    }

    @CallbackProp
    fun clickListener(listener: View.OnClickListener?) {
        setOnClickListener(listener)
    }
}