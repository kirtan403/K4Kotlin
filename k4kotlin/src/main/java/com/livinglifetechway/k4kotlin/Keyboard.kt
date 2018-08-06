package com.livinglifetechway.k4kotlin

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Hides the soft keyboard
 */
fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    try {
        view?.let {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    } catch (e: TypeCastException) {
        return false
    }
    return false
}
