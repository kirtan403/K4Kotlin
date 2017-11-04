package com.livinglifetechway.k4kotlin

import android.content.Context
import android.view.View


/**
 * Hides all the views passed in the arguments
 */
fun Context.hideViews(vararg views: View) = views.forEach { it.visibility = View.GONE }

/**
 * Shows all the views passed in the arguments
 */
fun Context.showViews(vararg views: View) = views.forEach { it.visibility = View.VISIBLE }

/**
 * Converts px to dp
 */
fun Context.pxToDp(px: Float) = px / this.resources.displayMetrics.density

/**
 * Converts dp to px
 */
fun Context.dpToPx(dp: Float) = dp * this.resources.displayMetrics.density