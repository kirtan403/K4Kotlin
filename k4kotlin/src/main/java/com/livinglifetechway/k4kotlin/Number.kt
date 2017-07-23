@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

/**
 * Returns Zero (0) if it is null
 */
fun Number?.orZero(): Number = if (this != null) this else 0

fun Int?.orZero(): Int = if (this != null) this else 0

fun Float?.orZero(): Float = if (this != null) this else 0.0f

fun Double?.orZero(): Double = if (this != null) this else 0.0
