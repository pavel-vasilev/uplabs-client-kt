package com.pvasilev.uplabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import kotlinx.android.synthetic.main.fragment_base.*

class CreatePostFragment : BaseMvRxFragment() {
    private val viewModel: CreatePostViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.buildModelsWith { controller ->
            withState(viewModel) { state ->
                controller.apply {
                    for ((index, step) in state.steps.withIndex()) {
                        stepperItem {
                            id(index)
                            position(index + 1)
                            title(step.title)
                            summary(step.summary)
                            stepLayout(step.layout)
                            onContinue(viewModel::onContinueClicked)
                            onCancel(viewModel::onCancelClicked)
                            state(
                                when {
                                    state.currentStep == index -> StepperItemState.ACTIVE
                                    state.currentStep < index -> StepperItemState.INACTIVE
                                    else -> StepperItemState.DONE
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }
}