package com.livinglifetechway.k4kotlin

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Sets an empty state view for the Recycler view which automatically shown/hidden based on
 * current state of the data
 */
fun <VH : RecyclerView.ViewHolder> RecyclerView.Adapter<VH>.setEmptyStateView(view: View): RecyclerView.AdapterDataObserver {
    val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() = checkForEmptyState()
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) = checkForEmptyState()
        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) = checkForEmptyState()
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) = checkForEmptyState()
        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) = checkForEmptyState()
        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) = checkForEmptyState()

        internal fun checkForEmptyState() {
            if (itemCount == 0) {
                view.show()
            } else {
                view.hide()
            }
        }
    }

    // registers data set observers that checks and manages the empty state view
    registerAdapterDataObserver(dataObserver)

    // also make an initial call to checkForEmptyState
    dataObserver.checkForEmptyState()

    return dataObserver
}