package com.livinglifetechway.k4kotlin

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Runs a FragmentTransaction, then calls commit().
 */
private inline fun FragmentManager.transact(function: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        function()
    }.commit()
}
