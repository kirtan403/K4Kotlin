package com.livinglifetechway.k4kotlin

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
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

/**
 * Get color from ContextCompat.getColor(context,color)
 */
fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)

/**
 * Get color from ContextCompat.getColor(context,color)
 */
fun Context.getDrawableCompat(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)