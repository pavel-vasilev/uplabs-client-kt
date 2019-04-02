package com.pvasilev.uplabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_post_details.*

class PostDetailsFragment : BaseMvRxFragment<PostDetailsState, PostDetailsViewModel>() {
    override val viewModelFactory: BaseMvRxViewModelFactory<PostDetailsState, PostDetailsViewModel>
        get() = TODO()

    private val viewModel: PostDetailsViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_post_details, container, false)

    override fun invalidate() {
        withState(viewModel) {
            val post = it.post() ?: return@withState
            Glide.with(context!!).load(post.previewUrl).into(iv_preview)
            tv_title.text = post.title
            tv_description.text = post.description
            tv_comments.text = post.comments.toString()
            tv_comments_label.text = getString(R.string.label_comments)
            tv_votes.text = post.votes.toString()
            tv_votes_label.text = getString(R.string.label_votes)
            tv_views.text = post.views.toString()
            tv_views_label.text = getString(R.string.label_views)
        }
    }
}