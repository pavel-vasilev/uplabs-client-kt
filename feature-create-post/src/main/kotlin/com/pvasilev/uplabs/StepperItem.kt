package com.pvasilev.uplabs

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.item_step.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class StepperItem(context: Context) : LinearLayout(context) {
    init {
        inflate(context, R.layout.item_step, this)
    }

    @ModelProp
    fun position(position: Int) {
        tv_position.text = position.toString()
    }

    @TextProp
    fun title(title: CharSequence) {
        tv_title.text = title
    }

    @TextProp
    fun summary(summary: CharSequence) {
        tv_summary.text = summary
    }

    @ModelProp
    fun stepLayout(layoutRes: Int) {
        inflate(context, layoutRes, step_container)
    }

    @ModelProp
    fun state(state: StepperItemState) {
        when (state) {
            StepperItemState.ACTIVE -> {
                tv_position.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#008577"))
                tv_position.visibility = View.VISIBLE
                iv_done.visibility = View.INVISIBLE
                btn_continue.visibility = View.VISIBLE
                btn_cancel.visibility = View.VISIBLE
                step_container.visibility = View.VISIBLE
            }
            StepperItemState.INACTIVE -> {
                tv_position.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#48000000"))
                tv_position.visibility = View.VISIBLE
                iv_done.visibility = View.INVISIBLE
                btn_continue.visibility = View.INVISIBLE
                btn_cancel.visibility = View.INVISIBLE
                step_container.visibility = View.GONE
            }
            StepperItemState.DONE -> {
                iv_done.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#008577"))
                tv_position.visibility = View.INVISIBLE
                iv_done.visibility = View.VISIBLE
                btn_continue.visibility = View.INVISIBLE
                btn_cancel.visibility = View.INVISIBLE
                step_container.visibility = View.GONE
            }
        }
    }

    @CallbackProp
    fun onContinue(callback: (() -> Unit)?) {
        btn_continue.setOnClickListener {
            callback?.invoke()
        }
    }

    @CallbackProp
    fun onCancel(callback: (() -> Unit)?) {
        btn_cancel.setOnClickListener {
            callback?.invoke()
        }
    }
}