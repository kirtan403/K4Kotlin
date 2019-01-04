package com.livinglifetechway.k4kotlin_retrofit

import kotlinx.coroutines.CompletableDeferred
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
 * Enqueues the current call, wait for the result (T = response.getBody()) and returns the result in a synchronous way.
 * This is a suspending function and should be used in the coroutines.
 * You can optionally pass the lifecycleOwner (activity/fragment) to scope the call.
 * Also you can optionally pass the callback function as well,
 * it will be called before returning results.
 *
 * NOTE: This is an experimental API. Please report bugs if you find any.
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
            if (response?.body() != null) {
                deferred.complete(response.body()!!)
            } else {
                deferred.completeExceptionally(kotlin.NullPointerException("Result body is null"))
            }

        }

    })

    return deferred.await()
}


/**
 * Enqueues the current call, and return the deferred type (Deferred<T>)
 * So you can get the results with await() call on it.
 * This is a suspending function and should be used in the coroutines.
 * You can optionally pass the lifecycleOwner (activity/fragment) to scope the call.
 * Also you can optionally pass the callback function as well,
 * it will be called when results are available.
 *
 * NOTE: This is an experimental API. Please report bugs if you find any.
 */
fun <T> Call<T>.enqueueDeferred(lifeCycleOwner: LifecycleOwner? = null, callback: Callback<T>? = null): CompletableDeferred<T> {

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
 * Enqueues the current call, and return the response with the deferred type (Deferred<Response<T>>)
 * So you can get the response object with await() call on it.
 * It is the same object you receive on onResponse callback
 * This is a suspending function and should be used in the coroutines.
 * You can optionally pass the lifecycleOwner (activity/fragment) to scope the call.
 * Also you can optionally pass the callback function as well,
 * it will be called when results are available.
 *
 * NOTE: This is an experimental API. Please report bugs if you find any.
 */
fun <T> Call<T>.enqueueDeferredResponse(lifeCycleOwner: LifecycleOwner? = null, callback: Callback<T>? = null): CompletableDeferred<Response<T>> {

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
