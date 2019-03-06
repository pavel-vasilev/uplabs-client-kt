package com.pvasilev.uplabs

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_file_input.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class FileInput(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_file_input, this)
    }

    @ModelProp
    fun preview(url: String?) {
        if (url != null) {
            Glide.with(context)
                .load(url)
                .into(iv_preview)
        } else {
            iv_preview.setBackgroundColor(Color.parseColor("#BDBDBD"))
        }
    }

    @ModelProp
    fun progress(isLoading: Boolean) {
        if (isLoading) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    @CallbackProp
    fun onFileSelected(callback: (() -> Unit)?) {
        iv_preview.setOnClickListener { callback?.invoke() }
    }

    @CallbackProp
    fun onFileRemoved(callback: (() -> Unit)?) {
        progressBar.setOnClickListener { callback?.invoke() }
    }
}