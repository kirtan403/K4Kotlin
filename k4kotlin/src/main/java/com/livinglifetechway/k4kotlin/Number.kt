@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

/**
 * Returns Zero (0) if it is null
 */
fun Number?.orZero(): Number = this ?: 0

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0

fun Float?.orZero(): Float = this ?: 0.0f

fun Double?.orZero(): Double = this ?: 0.0
