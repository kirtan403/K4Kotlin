package com.livinglifetechway.k4kotlin

import android.content.Context
import androidx.fragment.app.Fragment
import android.widget.Toast

/** Display a toast **/
fun Context?.toast(msg: String, duration: Int = Toast.LENGTH_LONG) = makeToast(this, msg, duration)

/** Display a toast **/
fun Fragment?.toast(msg: String) = makeToast(this?.context, msg, Toast.LENGTH_LONG)

/** Display a short toast **/
fun Context?.shortToast(msg: String) = makeToast(this, msg, Toast.LENGTH_SHORT)

/** Display a short toast **/
fun Fragment?.shortToast(msg: String) = makeToast(this?.context, msg, Toast.LENGTH_SHORT)

/** Display a long toast **/
fun Context?.longToast(msg: String) = makeToast(this, msg, Toast.LENGTH_LONG)

/** Display a long toast **/
fun Fragment?.longToast(msg: String) = makeToast(this?.context, msg, Toast.LENGTH_LONG)


/** Display a toast after cancelling any currently displayed toasts **/
fun Context?.toastNow(msg: String, duration: Int = Toast.LENGTH_LONG) = cancelAndMakeToast(this, msg, duration)

/** Display a toast after cancelling any currently displayed toasts **/
fun Fragment?.toastNow(msg: String) = cancelAndMakeToast(this?.context, msg, Toast.LENGTH_LONG)

/** Display a short toast after cancelling any currently displayed toasts **/
fun Context?.shortToastNow(msg: String) = cancelAndMakeToast(this, msg, Toast.LENGTH_SHORT)

/** Display a short toast after cancelling any currently displayed toasts **/
fun Fragment?.shortToastNow(msg: String) = cancelAndMakeToast(this?.context, msg, Toast.LENGTH_SHORT)

/** Display a long toast after cancelling any currently displayed toasts **/
fun Context?.longToastNow(msg: String) = cancelAndMakeToast(this, msg, Toast.LENGTH_LONG)

/** Display a long toast after cancelling any currently displayed toasts **/
fun Fragment?.longToastNow(msg: String) = cancelAndMakeToast(this?.context, msg, Toast.LENGTH_LONG)

/** Cancels all currently displayed taosts **/
fun cancelAllToasts() = ToastQueue.cancelToasts()

private fun cancelAndMakeToast(ctx: Context?, msg: String, duration: Int): Toast? {
    ToastQueue.cancelToasts()
    return makeToast(ctx, msg, duration)
}

private fun makeToast(ctx: Context?, msg: String, duration: Int): Toast? {
    return ctx?.let {
        val toast = Toast.makeText(ctx, msg, duration)
        toast.show()
        // remove from list after 4 seconds (longest toast time is 3.5 seconds)
        toast.view?.postDelayed({
            ToastQueue.removeToast(toast)
        }, 4000L)
        ToastQueue.toastQueue.add(toast)
        toast
    }
}

private object ToastQueue {
    val toastQueue = mutableListOf<Toast>()


    internal fun cancelToasts() {
        toastQueue.forEach { it.cancel() }
        toastQueue.clear()
    }

    internal fun removeToast(toast: Toast) = toastQueue.remove(toast)

}