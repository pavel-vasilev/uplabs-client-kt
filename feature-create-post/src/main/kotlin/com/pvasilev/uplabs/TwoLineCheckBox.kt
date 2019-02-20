package com.pvasilev.uplabs

import android.content.Context
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_checkbox_two_line.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TwoLineCheckBox(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_checkbox_two_line, this)
    }

    @ModelProp
    fun checked(isChecked: Boolean) {
        checkbox.isChecked = isChecked
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @TextProp
    fun subtitle(subtitle: CharSequence) {
        tv_subtitle.text = subtitle
    }
}