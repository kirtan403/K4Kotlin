package com.livinglifetechway.k4kotlin.core

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.util.Base64
import android.view.View
import java.io.ByteArrayOutputStream
import java.io.IOException


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

/**
 * Converts bitmap to bas64 string
 * @return base64 representation of the bitmap
 */
fun Bitmap.toBase64(): String {
    var result = ""
    val baos = ByteArrayOutputStream()
    try {
        compress(Bitmap.CompressFormat.JPEG, 100, baos)
        baos.flush()
        baos.close()
        val bitmapBytes = baos.toByteArray()
        result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT)
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            baos.flush()
            baos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return result
}

/**
 * Resize the bitmap to specified height and width.
 */
fun Bitmap.resize(newWidth: Number, newHeight: Number): Bitmap {
    val width = width
    val height = height
    val scaleWidth = newWidth.toFloat() / width
    val scaleHeight = newHeight.toFloat() / height
    val matrix = Matrix()
    matrix.postScale(scaleWidth, scaleHeight)
    if (width > 0 && height > 0) {
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }
    return this
}

