package com.livinglifetechway.k4kotlin

import android.app.Activity
import android.view.inputmethod.InputMethodManager

/**
 * Hides the soft keyboard
 */
fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(InputMethodManager::class.java)
        return inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
    return false
}
