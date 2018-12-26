package com.livinglifetechway.k4kotlin.core

/**
 * Checks if a string is a valid email
 */
fun String.isEmail() = android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Checks if String is Number.
 * Checks against regex `^[0-9]+$`
 */
fun String.isNumeric(): Boolean {
    val p = "^[0-9]+$".toRegex()
    return matches(p)
}