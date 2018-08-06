package com.livinglifetechway.k4kotlin_retrofit

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import retrofit2.Call
import retrofit2.Callback

/**
 * Excepts the an object of lifecycle owner (activity,fragment etc) as the first argument so that,
 * call will continue till the lifecycle is active.
 * Once the lifecycle finishes, the existing call will be cancelled
 * Note: Cancelling an running call will call onFailure method,
 *       so you should handle your cancelled call properly in onFailure
 */
fun <T> Call<T>.enqueue(lifecycleOwner: LifecycleOwner, callback: Callback<T>) {
    // add an observer to activity which will cancel an ongoing call
    // when activity is destroyed
    lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun cancelCalls() {
            cancel()
        }
    })
    enqueue(callback)
}
