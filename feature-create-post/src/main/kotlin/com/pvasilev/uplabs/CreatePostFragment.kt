package com.pvasilev.uplabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pvasilev.uplabs.models.License
import kotlinx.android.synthetic.main.fragment_base.*

class CreatePostFragment : BaseMvRxFragment<CreatePostState, CreatePostViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<CreatePostState, CreatePostViewModel>
        get() = TODO()

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
                    for (i in 0 until 4) {
                        step {
                            id(i)
                            position(i + 1)
                            title("Title of step $i")
                            summary("Summary of step $i")
                            onContinue(viewModel::onContinueClicked)
                            onCancel(viewModel::onCancelClicked)
                            models(
                                when (state.currentStep) {
                                    0 -> buildStep1(state)
                                    1 -> buildStep2(state)
                                    2 -> buildStep3(state)
                                    else -> buildStep4(state)
                                }
                            )
                            state(
                                when {
                                    state.currentStep == i -> StepState.ACTIVE
                                    state.currentStep < i -> StepState.INACTIVE
                                    else -> StepState.DONE
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

    private fun buildStep1(state: CreatePostState): List<EpoxyModel<*>> {
        return listOf(
            FileInputModel_()
                .id(1)
                .preview(state.preview()?.fileUrl)
                .progress(state.preview is Loading)
                .onFileSelected(viewModel::onPreviewChanged)
        )
    }

    private fun buildStep2(state: CreatePostState): List<EpoxyModel<*>> {
        return listOf(
            TextInputModel_()
                .id(1)
                .text(state.title)
                .hint(R.string.hint_title)
                .onTextChanged(viewModel::onTitleChanged),
            TextInputModel_()
                .id(2)
                .text(state.description)
                .hint(R.string.hint_description)
                .onTextChanged(viewModel::onDescriptionChanged)
        )
    }

    private fun buildStep3(state: CreatePostState): List<EpoxyModel<*>> {
        return listOf(
            SelectorInputModel_()
                .id(1)
                .hint(R.string.hint_category)
                .selected(state.category.name)
                .options(resources.getStringArray(R.array.categories))
                .onSelected(viewModel::onCategoryChanged),
            SelectorInputModel_()
                .id(2)
                .hint(R.string.hint_subcategory)
                .selected(state.subcategory.name)
                .options(resources.getStringArray(R.array.subcategories))
                .onSelected(viewModel::onSubcategoryChanged)
        )
    }

    private fun buildStep4(state: CreatePostState): List<EpoxyModel<*>> {
        return listOf(
            TwoLineCheckBoxModel_()
                .id(1)
                .title(R.string.title_free_license)
                .subtitle(R.string.subtitle_free_license)
                .checked(state.license is License.Free)
                .onCheckedChanged(viewModel::onFreeLicenseChanged),
            TwoLineCheckBoxModel_()
                .id(2)
                .title(R.string.title_commercial_license)
                .subtitle(R.string.subtitle_commercial_license)
                .checked(state.license is License.Commercial)
                .onCheckedChanged(viewModel::onCommercialLicenseChanged)
        )
    }
}