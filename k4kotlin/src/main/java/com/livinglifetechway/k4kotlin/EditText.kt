package com.livinglifetechway.k4kotlin

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Easier way to get string from edit text and set the string to it
 */
var EditText.value: String
    get() = text.toString()
    set(value) = setText(value)

/**
 * Accepts 3 text watcher methods with default empty implementation.
 * Returns the TextWatcher added to EditText
 */
fun EditText.addTextWatcher(afterTextChanged: (s: Editable?) -> Unit = { _ -> },
                            beforeTextChanged: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit = { _, _, _, _ -> },
                            onTextChanged: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit = { _, _, _, _ -> }): TextWatcher {

    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged(s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChanged(s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged(s, start, before, count)
        }
    }

    addTextChangedListener(textWatcher)
    return textWatcher
}