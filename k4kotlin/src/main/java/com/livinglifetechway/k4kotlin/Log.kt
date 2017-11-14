package com.livinglifetechway.k4kotlin

import android.util.Log

/**
 * Returns class name. Useful for Log Tags
 */
val Any.TAG: String
    get() = this::class.java.simpleName

/**
 * Logs current object as Debug
 */
fun Any.logD(tag: String = TAG) = Log.d(tag, toString())

/**
 * Logs current object as Information
 */
fun Any.logI(tag: String = TAG) = Log.i(tag, toString())

/**
 * Logs current object as Verbose
 */
fun Any.logV(tag: String = TAG) = Log.v(tag, toString())

/**
 * Logs current object as Warning
 */
fun Any.logW(tag: String = TAG) = Log.w(tag, toString())

/**
 * Logs current object as Error
 */
fun Any.logE(tag: String = TAG) = Log.e(tag, toString())

/**
 * Logs current object as Wtf (What a Terrible Failure)
 */
fun Any.logWtf(tag: String = TAG) = Log.wtf(tag, toString())