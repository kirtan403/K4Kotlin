package com.livinglifetechway.k4kotlin

/**
 * Utility functions for all classes
 */

/**
 * Returns class name. Useful for Log Tags
 */
val Any.TAG: String
    get() = this::class.java.simpleName
