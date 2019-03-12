package com.pvasilev.uplabs

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.pvasilev.uplabs.models.*
import com.pvasilev.uplabs.network.PostService
import com.pvasilev.uplabs.network.UploadService
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.File

class CreatePostViewModel @AssistedInject constructor(
    @Assisted initialState: CreatePostState,
    private val config: Config,
    private val postService: PostService,
    private val uploadService: UploadService
) : BaseMvRxViewModel<CreatePostState>(initialState) {
    fun onContinueClicked() {
        withState {
            if (it.currentStep == 3) {
                val sourceUrl = it.source()?.fileUrl
                val previewUrl = it.source()?.fileUrl
                if (sourceUrl != null && previewUrl != null) {
                    postService.create(
                        config.authenticityToken,
                        it.title,
                        it.description,
                        it.category.id,
                        it.subcategory.id,
                        if (it.license is License.Free) 1 else 0,
                        if (it.license is License.Free) 0 else 1,
                        it.tool.value,
                        sourceUrl,
                        previewUrl
                    )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
            } else {
                setState { copy(currentStep = currentStep + 1) }
            }
        }
    }

    fun onCancelClicked() {
        withState {
            if (it.currentStep > 0) {
                setState { copy(currentStep = currentStep - 1) }
            }
        }
    }

    fun onPreviewChanged(file: File) {
        val contentType = "image/png"
        val requestBody = RequestBody.create(MediaType.parse(contentType), file)
        uploadService.getSigningUrl(file.name, contentType)
            .flatMap {
                uploadService.upload(it.signedUrl, contentType, requestBody).andThen(Observable.just(it))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .execute { copy(preview = it) }
    }

    fun onTitleChanged(title: String) {
        setState { copy(title = title) }
    }

    fun onDescriptionChanged(description: String) {
        setState { copy(description = description) }
    }

    fun onCategoryChanged(category: String) {
        setState { copy(category = Category.valueOf(category)) }
    }

    fun onSubcategoryChanged(subcategory: String) {
        setState { copy(subcategory = Subcategory.valueOf(subcategory)) }
    }

    fun onToolChanged(tool: String) {
        setState { copy(tool = Tool.valueOf(tool)) }
    }

    fun onFreeLicenseChanged(isChecked: Boolean) {
        if (isChecked) {
            setState { copy(license = License.Free) }
        } else {
            setState { copy(license = License.Commercial(15.0F)) }
        }
    }

    fun onCommercialLicenseChanged(isChecked: Boolean) {
        if (isChecked) {
            setState { copy(license = License.Commercial(15.0F)) }
        } else {
            setState { copy(license = License.Free) }
        }
    }

    @AssistedInject.Factory
    interface Factory : BaseMvRxViewModelFactory<CreatePostState, CreatePostViewModel>

    companion object : MvRxViewModelFactory<CreatePostViewModel, CreatePostState> {
        override fun create(viewModelContext: ViewModelContext, state: CreatePostState): CreatePostViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<CreatePostFragment>()
            val factory = fragment.viewModelFactory
            return factory.create(state)
        }
    }
}