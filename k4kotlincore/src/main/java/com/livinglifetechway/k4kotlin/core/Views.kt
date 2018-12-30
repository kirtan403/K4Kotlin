@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin.core

import android.content.res.Resources
import android.view.View
import android.view.ViewPropertyAnimator

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

/**
 * Fades in the View
 */
inline fun View.fadeIn(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .alpha(1.0f)
            .setDuration(duration)
}

/**
 * Fades out the View
 */
inline fun View.fadeOut(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .alpha(0.0f)
            .setDuration(duration)
}

/**
 * Fades to a specific alpha between 0 to 1
 */
inline fun View.fadeTo(alpha: Float, duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .alpha(alpha)
            .setDuration(duration)
}

/**
 * Animation: Enter from left
 */
inline fun View.enterFromLeft(duration: Long = 400): ViewPropertyAnimator? {
    val x = this.x    // store initial x
    this.x = 0f - this.width    // move to left

    return animate()
            .x(x)
            .setDuration(duration)
}

/**
 * Animation: Enter from right
 */
inline fun View.enterFromRight(duration: Long = 400): ViewPropertyAnimator? {
    val widthPixels = Resources.getSystem().displayMetrics.widthPixels    // get device width
    val x = this.x    // store initial x
    this.x = widthPixels.toFloat()    // move to right

    return animate()
            .x(x)
            .setDuration(duration)
}

/**
 * Animation: Enter from top
 */
inline fun View.enterFromTop(duration: Long = 400): ViewPropertyAnimator? {
    val y = this.y    // store initial y
    this.y = 0f - this.height    // move to top

    return animate()
            .y(y)
            .setDuration(duration)
}

/**
 * Animation: Enter from bottom
 */
inline fun View.enterFromBottom(duration: Long = 400): ViewPropertyAnimator? {
    val heightPixels = Resources.getSystem().displayMetrics.heightPixels    // get device height

    val y = this.y    // store initial y
    this.y = heightPixels.toFloat()   // move to bottom

    return animate()
            .y(y)
            .setDuration(duration)
}

/**
 * Animation: Exit to left
 */
inline fun View.exitToLeft(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .x(0f - this.width)
            .setDuration(duration)
}

/**
 * Animation: Exit to right
 */
inline fun View.exitToRight(duration: Long = 400): ViewPropertyAnimator? {
    val widthPixels = Resources.getSystem().displayMetrics.widthPixels    // get device width

    return animate()
            .x(widthPixels.toFloat())
            .setDuration(duration)
}

/**
 * Animation: Exit to top
 */
inline fun View.exitToTop(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .y(0f - this.height)
            .setDuration(duration)
}

/**
 * Animation: Exit to bottom
 */
inline fun View.exitToBottom(duration: Long = 400): ViewPropertyAnimator? {
    val heightPixels = Resources.getSystem().displayMetrics.heightPixels    // get device height

    return animate()
            .y(heightPixels.toFloat())
            .setDuration(duration)
}
