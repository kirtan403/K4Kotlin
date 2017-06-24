@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

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
 * Toggle's view's visibility. If View is visible, then sets to gone. Else sets Visible
 */
inline fun View.toggle() {
    visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
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
