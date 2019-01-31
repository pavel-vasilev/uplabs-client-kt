package com.pvasilev.uplabs

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessScrollListener(private val callback: () -> Unit) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager!!
        val itemCount = layoutManager.itemCount
        val lastVisiblePosition = when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
            else -> 0
        }
        if (lastVisiblePosition + VISIBLE_THRESHOLD > itemCount) {
            callback()
        }
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }
}