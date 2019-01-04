package com.livinglifetechway.k4kotlin.core

import android.app.Activity
import android.content.Context
import android.content.Intent


/**
 * Starts teh activity of the given class type
 */
inline fun <reified T : Activity> Context?.startActivity() = this?.startActivity(Intent(this, T::class.java))