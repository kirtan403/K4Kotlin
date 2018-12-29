package com.livinglifetechway.k4kotlin.core

import android.content.Context

/**
 * Converts px to dp
 * @receiver Context
 * @param px value in pixels that needs to be converted to dp
 * @return dp value
 */
fun Context.pxToDp(px: Float) = px / this.resources.displayMetrics.density

/**
 * Converts dp to px
 * @receiver Context
 * @param dp value in dp that needs to be converted to px
 * @return px value
 */
fun Context.dpToPx(dp: Float) = (dp * this.resources.displayMetrics.density).toInt()

/**
 * Converts sp to px
 * @receiver Context
 * @param sp value in sp that needs to be converted to px
 * @return px value
 */
fun Context.spToPx(sp: Float) = (sp * this.resources.displayMetrics.scaledDensity).toInt()

/**
 * Converts px to sp
 * @receiver Context
 * @param px value in pixels that needs to be converted to sp
 * @return sp value
 */
fun Context.pxToSp(px: Float) = px / this.resources.displayMetrics.scaledDensity
