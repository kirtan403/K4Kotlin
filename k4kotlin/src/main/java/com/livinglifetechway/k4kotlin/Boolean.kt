@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

/**
 * Returns false if it is null
 */
fun Boolean?.orFalse(): Boolean = this ?: false
