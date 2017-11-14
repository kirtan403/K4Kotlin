package com.livinglifetechway.k4kotlin

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

/**
 * Get color from ContextCompat.getColor(context,color)
 */
fun Context.getDrawableCompat(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)
