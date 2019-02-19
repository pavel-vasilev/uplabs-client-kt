package com.pvasilev.uplabs

import com.airbnb.mvrx.MvRxState
import com.pvasilev.uplabs.models.Category
import com.pvasilev.uplabs.models.License
import com.pvasilev.uplabs.models.Subcategory

data class CreatePostState(
    val currentStep: Int = 0,
    val steps: List<Step> = listOf(
        Step("Title of step 1", "Summary of step 1", R.layout.step_upload),
        Step("Title of step 2", "Summary of step 2", R.layout.step_info),
        Step("Title of step 3", "Summary of step 3", R.layout.step_category),
        Step("Title of step 4", "Summary of step 4", R.layout.step_license)
    ),
    val title: String = "",
    val description: String = "",
    val category: Category = Category.Android,
    val subcategory: Subcategory = Subcategory.Template,
    val license: License = License.Free
) : MvRxState