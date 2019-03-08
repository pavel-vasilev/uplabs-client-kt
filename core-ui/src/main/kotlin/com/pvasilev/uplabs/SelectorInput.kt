package com.pvasilev.uplabs

import android.content.Context
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_selector.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SelectorInput(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_selector, this)
    }

    @TextProp
    fun hint(hint: CharSequence) {
        et_input.hint = hint
    }

    @ModelProp
    fun selected(selected: String) {
        et_input.setText(Editable.Factory.getInstance().newEditable(selected), false)
    }

    @ModelProp
    fun options(options: Array<String>) {
        et_input.setAdapter(ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, options))
    }

    @CallbackProp
    fun onSelected(callback: ((String) -> Unit)?) {
        et_input.addTextChangedListener { callback?.invoke(it.toString()) }
    }
}