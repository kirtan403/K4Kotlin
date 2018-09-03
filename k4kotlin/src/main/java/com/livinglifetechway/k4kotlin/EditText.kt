package com.livinglifetechway.k4kotlin

import android.text.Editable
import android.text.TextWatcher
import android.text.method.ReplacementTransformationMethod
import android.widget.EditText

/**
 * Easier way to get string from edit text and set the string to it
 */
var <T : EditText> T.value: String
    get() = text.toString()
    set(value) = setText(value)

/**
 * Sets Transformation to uppercase. Converts all lowercase letters typed to uppercase
 */
fun <T : EditText> T.setUppercaseTransformation() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = lower

        override fun getReplacement() = upper
    }
}

/**
 * Sets Transformation to lowercase. Converts all uppercase letters typed to lowercase
 */
fun <T : EditText> T.setLowercaseTransformation() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = upper

        override fun getReplacement() = lower
    }
}

/**
 * Accepts 3 text watcher methods with default empty implementation.
 * Returns the TextWatcher added to EditText
 */
fun <T : EditText> T.addTextWatcher(afterTextChanged: (s: Editable?) -> Unit = { _ -> },
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