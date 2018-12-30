package com.livinglifetechway.k4kotlin.core

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View


/**
 * Get the view as bitmap
 * @param bitmapConfig An optional parameter specifying bitmap config value
 * @return Bitmap representation of the view
 */
fun View.getBitmap(bitmapConfig: Bitmap.Config = Bitmap.Config.ARGB_8888): Bitmap {
    val bmp = Bitmap.createBitmap(width, height, bitmapConfig)
    val canvas = Canvas(bmp)
    draw(canvas)
    canvas.save()
    return bmp
}