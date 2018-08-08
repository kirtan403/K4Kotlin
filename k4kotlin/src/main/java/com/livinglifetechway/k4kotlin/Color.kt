package com.livinglifetechway.k4kotlin

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Get color from ContextCompat.getColor(context,color)
 */
fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)

/**
 * Get color state list from ContextCompat.getColorStateList(context,color)
 */
fun Context.getColorStateListCompat(@ColorRes color: Int) = ContextCompat.getColorStateList(this, color)
