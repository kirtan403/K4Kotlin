package com.livinglifetechway.k4kotlin.core

import android.util.Log

/**
 * Returns class name. Useful for Log Tags
 */
val Any.TAG: String
    get() = this::class.java.simpleName

/**
 * Logs a debug message
 * @param msg object to log
 */
inline fun <reified T> T.debug(msg: Any?, throwable: Throwable? = null) = Log.d(this!!.TAG, msg.toString(), throwable)

/**
 * Logs a info message
 * @param msg object to log
 */
inline fun <reified T> T.info(msg: Any?, throwable: Throwable? = null) = Log.i(this!!.TAG, msg.toString(), throwable)


/**
 * Logs a verbose message
 * @param msg object to log
 */
inline fun <reified T> T.verbose(msg: Any?, throwable: Throwable? = null) = Log.v(this!!.TAG, msg.toString(), throwable)

/**
 * Logs a warning message
 * @param msg object to log
 */
inline fun <reified T> T.warning(msg: Any?, throwable: Throwable? = null) = Log.w(this!!.TAG, msg.toString(), throwable)

/**
 * Logs an error message
 * @param msg object to log
 */
inline fun <reified T> T.err(msg: Any?, throwable: Throwable? = null) = Log.e(this!!.TAG, msg.toString(), throwable)


/**
 * Logs a wtf message
 * @param msg object to log
 */
inline fun <reified T> T.wtf(msg: Any?, throwable: Throwable? = null) = Log.wtf(this!!.TAG, msg.toString(), throwable)