package com.livinglifetechway.k4kotlin_retrofit

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback

/**
 * Excepts the activity as the first argument so that,
 * call will continue till the activity is present.
 * Once the activity finishes, the existing call will be cancelled
 * Note: Cancelling an running call will call onFailure method,
 *       so you should handle your cancelled call properly in onFailure
 */
fun <T> Call<T>.enqueue(activity: AppCompatActivity, callback: Callback<T>) {
    // add an observer to activity which will cancel an ongoing call
    // when activity is destroyed
    activity.lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun cancelCalls() {
            this@enqueue.cancel()
        }
    })
    this.enqueue(callback)
}