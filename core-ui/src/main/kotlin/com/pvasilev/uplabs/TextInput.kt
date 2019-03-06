package com.pvasilev.uplabs

import android.content.Context
import android.text.Editable
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_text_input.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TextInput(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_text_input, this)
    }

    @TextProp
    fun text(text: CharSequence) {
        et_input.text = Editable.Factory.getInstance().newEditable(text)
    }

    @TextProp
    fun hint(hint: CharSequence) {
        et_input.hint = hint
    }

    @CallbackProp
    fun onTextChanged(callback: ((String) -> Unit)?) {
        et_input.addTextChangedListener { callback?.invoke(it.toString()) }
    }
}