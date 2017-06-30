@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

/**
 * Returns Zero (0) if it is null
 */
fun Number?.orZero(): Number? = if (this != null) this else 0
