package com.livinglifetechway.k4kotlin

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Sets an empty state view for the Recycler view which automatically shown/hidden based on
 * current state of the data
 */
fun <VH : RecyclerView.ViewHolder> RecyclerView.Adapter<VH>.setEmptyStateView(view: View): RecyclerView.AdapterDataObserver {
    val dataObserver = EmptyStateObserver(this) { empty ->
        if (empty) {
            view.show()
        } else {
            view.hide()
        }
    }

    // registers data set observers that checks and manages the empty state view
    registerAdapterDataObserver(dataObserver)

    // also make an initial call to checkForEmptyState
    dataObserver.checkForEmptyState()

    return dataObserver
}

private class EmptyStateObserver<VH: RecyclerView.ViewHolder>(private val adapter: RecyclerView.Adapter<VH>, private val onStateChanged: (empty: Boolean) -> Unit): RecyclerView.AdapterDataObserver() {

    override fun onChanged() = checkForEmptyState()
    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) = checkForEmptyState()
    override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) = checkForEmptyState()
    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) = checkForEmptyState()
    override fun onItemRangeChanged(positionStart: Int, itemCount: Int) = checkForEmptyState()
    override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) = checkForEmptyState()

    fun checkForEmptyState() {
        if (adapter.itemCount == 0) {
            onStateChanged(true)
        } else {
            onStateChanged(false)
        }
    }

}