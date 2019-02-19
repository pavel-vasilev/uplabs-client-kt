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
                    step {
                        id(0)
                        position(1)
                        title("Title of step 1")
                        summary("Summary of step 1")
                        onContinue(viewModel::onContinueClicked)
                        onCancel(viewModel::onCancelClicked)
                        models(listOf())
                        state(
                            when {
                                state.currentStep == 0 -> StepState.ACTIVE
                                state.currentStep < 0 -> StepState.INACTIVE
                                else -> StepState.DONE
                            }
                        )
                    }
                }
            }
        }
    }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }
}