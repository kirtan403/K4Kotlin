package com.livinglifetechway.k4kotlin.core.androidx

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


/**
 * Instantiates an [AlertDialog.Builder] for the [Activity], applies the [dialogConfig] lambda to
 * it, then creates an [AlertDialog] from the builder, and returns it, so you can call
 * [AlertDialog.show] on the created dialog.
 */
inline fun Activity.alert(dialogConfig: AlertDialog.Builder.() -> Unit): AlertDialog {
    return AlertDialog.Builder(this)
            .apply(dialogConfig)
            .create()
}

/**
 * The fragment version of the alert dialog builder
 */
inline fun Fragment.alert(dialogConfig: AlertDialog.Builder.() -> Unit) = activity?.alert(dialogConfig)