package com.pvasilev.uplabs

import android.content.Context
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_preview.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class PostPreview(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_preview, this)
    }

    @TextProp
    fun preview(url: CharSequence) {
        Glide.with(context)
            .load(url)
            .into(iv_preview)
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @ModelProp
    fun views(views: Int) {
        tv_views.text = views.toString()
    }

    @ModelProp
    fun comments(comments: Int) {
        tv_comments.text = comments.toString()
    }

    @ModelProp
    fun downloads(downloads: Int) {
        tv_downloads.text = downloads.toString()
    }

    @TextProp
    fun avatar(url: CharSequence) {
        Glide.with(context)
            .load(url)
            .into(iv_avatar)
    }
}