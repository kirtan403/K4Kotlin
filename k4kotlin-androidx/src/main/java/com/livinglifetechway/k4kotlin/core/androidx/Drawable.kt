package com.livinglifetechway.k4kotlin.core.androidx

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


/**
 * Get the drawable with ContextCompat
 * @param drawableRes id of the drawable resource (R.drawable.ic_notification)
 * @return Drawable instance
 */
fun Context.drawable(@DrawableRes drawableRes: Int) = ContextCompat.getDrawable(this, drawableRes)

/**
 * Get the drawable with ContextCompat
 * @param drawableRes id of the drawable resource (R.drawable.ic_notification)
 * @return Drawable instance
 */
fun Fragment.drawable(@DrawableRes drawableRes: Int) = context?.drawable(drawableRes)