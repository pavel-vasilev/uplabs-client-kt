package com.pvasilev.uplabs

import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import androidx.appcompat.R
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class AutoCompleteTextInputEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.autoCompleteTextViewStyle
) : AppCompatAutoCompleteTextView(context, attrs, defStyleAttr) {

    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection? {
        val ic = super.onCreateInputConnection(outAttrs)
        if (ic != null && outAttrs.hintText == null) {
            val parent = parent
            if (parent is TextInputLayout) {
                outAttrs.hintText = parent.hint
            }
        }
        return ic
    }
}
