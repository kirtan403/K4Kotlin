package com.livinglifetechway.k4kotlin

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Get color from [ContextCompat.getColor]
 */
fun Context.getDrawableCompat(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)

/**
 * Set drawable tint from [DrawableCompat.setTint]
 */
fun Drawable.setTintCompat(color: Int) = DrawableCompat.setTint(DrawableCompat.wrap(this), color)