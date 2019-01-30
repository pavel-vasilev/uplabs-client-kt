package com.pvasilev.uplabs

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_avatar_one_line.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class OneLineAvatar(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_avatar_one_line, this)
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @ModelProp
    fun avatar(url: String) {
        Glide.with(context)
            .load(url)
            .into(iv_avatar)
    }

    @CallbackProp
    fun clickListener(listener: View.OnClickListener?) {
        setOnClickListener(listener)
    }
}