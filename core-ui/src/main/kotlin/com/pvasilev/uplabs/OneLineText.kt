package com.pvasilev.uplabs

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_text_one_line.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class OneLineText(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_text_one_line, this)
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @CallbackProp
    fun onClick(callback: (() -> Unit)?) {
        setOnClickListener {
            callback?.invoke()
        }
    }
}