package com.livinglifetechway.k4kotlin

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat

/**
 * Get color from ContextCompat.getColor(context,color)
 */
fun Context.getDrawableCompat(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)

fun Drawable.setTintCompat(color: Int) = DrawableCompat.setTint(DrawableCompat.wrap(this), color)