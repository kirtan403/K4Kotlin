package com.livinglifetechway.k4kotlin.core

/**
 * Returns Zero (0) if it is null
 */
@Suppress("UNCHECKED_CAST")
fun <T : Number> T?.orZero(): T = this ?: (0 as T)

/**
 * Returns false if it is null
 */
fun Boolean?.orFalse(): Boolean = this ?: false

/**
 * Returns true if it is null
 * Warning: Please use this with caution. Boolean's default value is false
 */
fun Boolean?.orTrue(): Boolean = this ?: true

/**
 * Returns the default value specified in the argument
 * @param value default value
 * @return The number itself if not null or the default value casted to receiver type
 */
@Suppress("UNCHECKED_CAST")
fun <T : Number, J : Number> T?.orDefault(value: J): T = this ?: (value as T)