@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

/**
 * Returns Zero (0) if it is null
 */
fun Number?.orZero(): Number = this ?: 0

/**
 * Returns Zero (0) if it is null
 */
fun Int?.orZero(): Int = this ?: 0

/**
 * Returns Zero (0) if it is null
 */
fun Long?.orZero(): Long = this ?: 0

/**
 * Returns Zero (0) if it is null
 */
fun Float?.orZero(): Float = this ?: 0.0f

/**
 * Returns Zero (0) if it is null
 */
fun Double?.orZero(): Double = this ?: 0.0

/**
 * Returns false if it is null
 */
fun Boolean?.orFalse(): Boolean = this ?: false