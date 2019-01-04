package com.livinglifetechway.k4kotlin.core.androidx

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Get the color compat value of the color
 * @param colorRes id of the color resource (R.id.colorAccent)
 * @return Color instance
 */
fun Context.color(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

/**
 * Get the color compat value of the color
 * @param colorRes id of the color resource (R.id.colorAccent)
 * @return Color instance
 */
fun Fragment.color(@ColorRes colorRes: Int) = context?.color(colorRes)

