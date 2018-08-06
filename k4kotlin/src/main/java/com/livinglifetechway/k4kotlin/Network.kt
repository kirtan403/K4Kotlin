package com.livinglifetechway.k4kotlin

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.RequiresPermission

/**
 * Checks for network availability
 */
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isNetworkAvailable(): Boolean {
    val cm = getSystemService(ConnectivityManager::class.java)
    val network = cm.activeNetworkInfo
    return network != null && network.isConnected
}