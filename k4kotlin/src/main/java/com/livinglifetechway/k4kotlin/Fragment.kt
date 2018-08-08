package com.livinglifetechway.k4kotlin

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Runs a FragmentTransaction, then calls commit().
 */
inline fun FragmentManager.transact(function: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        function()
    }.commit()
}
