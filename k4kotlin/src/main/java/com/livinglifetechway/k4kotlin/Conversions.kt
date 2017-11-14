package com.livinglifetechway.k4kotlin

import android.content.Context

/**
 * Converts px to dp
 */
fun Context.pxToDp(px: Float) = px / this.resources.displayMetrics.density

/**
 * Converts dp to px
 */
fun Context.dpToPx(dp: Float) = dp * this.resources.displayMetrics.density
