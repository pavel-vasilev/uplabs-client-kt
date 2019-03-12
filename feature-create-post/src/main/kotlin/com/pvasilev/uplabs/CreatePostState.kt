package com.pvasilev.uplabs

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.pvasilev.uplabs.models.*

data class CreatePostState(
    val currentStep: Int = 0,
    val preview: Async<SignedUrl> = Uninitialized,
    val source: Async<SignedUrl> = Uninitialized,
    val title: String = "",
    val description: String = "",
    val category: Category = Category.Android,
    val subcategory: Subcategory = Subcategory.Template,
    val tool: Tool = Tool.Sketch,
    val license: License = License.Free
) : MvRxState