@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin.core

import android.view.View

/**
 * Sets the view's visibility to GONE
 */
inline fun View.hide() {
    visibility = View.GONE
}

/**
 * Sets the view's visibility to VISIBLE
 */
inline fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Sets the view's visibility to INVISIBLE
 */
inline fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * DEPRECATED
 * Toggle's view's visibility. If View is visible, then sets to gone. Else sets Visible
 */
@Deprecated("Use toggleVisibility() instead", ReplaceWith("this.toggleVisibility()", "android.view.View"))
inline fun View.toggle() = toggleVisibility()

/**
 * Toggle's view's visibility. If View is visible, then sets to gone. Else sets Visible
 * Previously knows as toggle()
 */
inline fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
}

/**
 * Hides all the views passed in the arguments
 */
fun hideViews(vararg views: View) = views.forEach { it.visibility = View.GONE }

/**
 * Shows all the views passed in the arguments
 */
fun showViews(vararg views: View) = views.forEach { it.visibility = View.VISIBLE }

/**
 * Sets the onClick listener on the View
 */
inline fun <T : View> T.onClick(crossinline function: T.() -> Unit) {
    setOnClickListener { function() }
}

/**
 * Sets the onLongClick listener on the View
 */
inline fun <T : View> T.onLongClick(crossinline function: T.() -> Unit) {
    setOnLongClickListener { function(); true }
}

/**
 * Can update the padding of the specified side without changing other values
 */
fun View.updatePadding(paddingStart: Int = getPaddingStart(),
                       paddingTop: Int = getPaddingTop(),
                       paddingEnd: Int = getPaddingEnd(),
                       paddingBottom: Int = getPaddingBottom()) {
    setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom)
}
