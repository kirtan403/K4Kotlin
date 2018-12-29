package com.livinglifetechway.k4kotlin.core

import android.text.Editable
import android.text.TextWatcher
import android.text.method.ReplacementTransformationMethod
import android.widget.EditText

/**
 * Easier way to get string from edit text and set the string to it
 */
var EditText.value: String
    get() = text.toString()
    set(value) = setText(value)


/**
 * Clears the value of the EditText
 * or you can say, sets the empty text
 * @receiver EditText
 */
fun EditText.clear() {
    this.value = ""
}

/**
 * Sets Transformation to uppercase. Converts all lowercase letters typed to uppercase
 * @receiver EditText
 */
fun EditText.setUppercaseTransformation() {
    transformationMethod = object : ReplacementTransformationMethod() {
        private val lower = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        private val upper = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        override fun getOriginal() = lower

        override fun getReplacement() = upper
    }
}

/**
 * Sets Transformation to lowercase. Converts all uppercase letters typed to lowercase
 * @receiver EditText
 */
fun EditText.setLowercaseTransformation() {
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
 * @receiver EditText
 * @param afterTextChanged optional function for after text changed invocation
 * @param beforeTextChanged optional function for before text changes invocation
 * @param onTextChanged function to be called when the text is changed
 * @return TextWatcher instance created
 */
fun EditText.addTextWatcher(afterTextChanged: (s: Editable?) -> Unit = { },
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