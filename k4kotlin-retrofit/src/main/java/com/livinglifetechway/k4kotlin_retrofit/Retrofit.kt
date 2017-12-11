package com.livinglifetechway.k4kotlin_retrofit

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.experimental.CompletableDeferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            this@enqueue.cancel()
        }
    })
    this.enqueue(callback)
}


/**
 *
 */
suspend fun <T> Call<T>.enqueueAwait(lifeCycleOwner: LifecycleOwner? = null, callback: Callback<T>? = null): T {

    val deferred = CompletableDeferred<T>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            this.cancel()
        }
    }

    lifeCycleOwner?.lifecycle?.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun cancelCalls() {
            this@enqueueAwait.cancel()
        }
    })

    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            callback?.onFailure(call, t)
            deferred.completeExceptionally(t!!)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            callback?.onResponse(call, response)
            deferred.complete(response?.body()!!)
        }

    })

    return deferred.await()
}


/**
 *
 */
suspend fun <T> Call<T>.enqueueDeferred(lifeCycleOwner: LifecycleOwner? = null, callback: Callback<T>? = null): CompletableDeferred<T> {

    val deferred = CompletableDeferred<T>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            this.cancel()
        }
    }

    lifeCycleOwner?.lifecycle?.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun cancelCalls() {
            this@enqueueDeferred.cancel()
        }
    })

    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            callback?.onFailure(call, t)
            deferred.completeExceptionally(t!!)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            callback?.onResponse(call, response)
            deferred.complete(response?.body()!!)
        }

    })

    return deferred
}


/**
 *
 */
suspend fun <T> Call<T>.enqueueDeferredResponse(lifeCycleOwner: LifecycleOwner? = null, callback: Callback<T>? = null): CompletableDeferred<Response<T>> {

    val deferred = CompletableDeferred<Response<T>>()

    deferred.invokeOnCompletion {
        if (deferred.isCancelled) {
            this.cancel()
        }
    }

    lifeCycleOwner?.lifecycle?.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun cancelCalls() {
            this@enqueueDeferredResponse.cancel()
        }
    })

    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            callback?.onFailure(call, t)
            deferred.completeExceptionally(t!!)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            callback?.onResponse(call, response)
            deferred.complete(response!!)
        }

    })

    return deferred
}
