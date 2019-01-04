package com.livinglifetechway.k4kotlinsample.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.k4kotlin.core.show
import com.livinglifetechway.k4kotlin.core.toast
import com.livinglifetechway.k4kotlin.databinding.setBindingView
import com.livinglifetechway.k4kotlin_retrofit.RetrofitCallback
import com.livinglifetechway.k4kotlin_retrofit.enqueue
import com.livinglifetechway.k4kotlin_retrofit.enqueueAwait
import com.livinglifetechway.k4kotlin_retrofit.enqueueDeferred
import com.livinglifetechway.k4kotlin_retrofit.enqueueDeferredResponse
import com.livinglifetechway.k4kotlinsample.R
import com.livinglifetechway.k4kotlinsample.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RetrofitActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = setBindingView(R.layout.activity_retrofit)

        // simple enqueue with lifecycle owner
        mBinding.btnEnqueue.setOnClickListener {
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""
            mBinding.tvInfo.append("Starting API call \n")
            ApiClient.service.getUserDetails().enqueue(this@RetrofitActivity, RetrofitCallback {
                progressView = mBinding.progressBar
                on200Ok { call, response ->
                    mBinding.tvInfo.append("Response Received \n")
                    mBinding.tvResponse.text = response?.body()?.toString()
                }
                onFailureNotCancelled { call, throwable ->
                    mBinding.tvInfo.append("Error: ${throwable?.message}\n")
                }
            })
            mBinding.tvInfo.append("API call enqueued \n")
        }

        // enqueue await
        mBinding.btnEnqueueAwait.setOnClickListener {
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            GlobalScope.async(Dispatchers.Main) {
                mBinding.tvInfo.append("Starting API call \n")
                val enqueueAwait = ApiClient.service.getUserDetails().enqueueAwait(this@RetrofitActivity, RetrofitCallback {
                    progressView = mBinding.progressBar

                    onResponseCallback { call, response ->
                        mBinding.tvInfo.append("Response Received \n")
                    }

                })
                mBinding.tvInfo.append("Await call complete \n")
                mBinding.tvResponse.text = enqueueAwait.toString()
            }
        }

        // enqueue await with error
        mBinding.btnEnqueueAwaitError.setOnClickListener {
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            val asyncTask = GlobalScope.async(Dispatchers.Main) {
                try {
                    mBinding.tvInfo.append("Starting API call \n")
                    val enqueueAwait = ApiClient.service.getUserDetailsError().enqueueAwait(this@RetrofitActivity, RetrofitCallback {
                        progressView = mBinding.progressBar

                        onResponseCallback { call, response ->
                            mBinding.tvInfo.append("Response Received \n")
                        }

                    })
                    mBinding.tvInfo.append("Await call complete \n")
                    mBinding.tvResponse.text = enqueueAwait.toString()
                } catch (e: Exception) {
                    mBinding.tvInfo.append("Crashed! \nException: ${e.message}")
                }
            }

            GlobalScope.async(Dispatchers.Main) {
                asyncTask.join()
                // you can check the state of the coroutine
                if (asyncTask.getCompletionExceptionOrNull() != null) toast("Exception")
            }
        }

        // deferred response body
        mBinding.btnEnqueueDeferred.setOnClickListener {
            mBinding.progressBar.show()
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            GlobalScope.async(Dispatchers.Main) {
                mBinding.tvInfo.append("Starting API call \n")
                val enqueueDeferred = ApiClient.service.getUserDetails().enqueueDeferred(this@RetrofitActivity, RetrofitCallback {
                    progressView = mBinding.progressBar
                    on200Ok { call, response ->
                        mBinding.tvInfo.append("Response received \n")
                    }
                })
                mBinding.tvInfo.append("API called \n")
                val result = enqueueDeferred.await()
                mBinding.tvInfo.append("Await call complete \n")
                mBinding.tvResponse.text = result.toString()

            }
        }

        // deferred response
        mBinding.btnEnqueueDeferredResp.setOnClickListener {
            mBinding.progressBar.show()
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            GlobalScope.async(Dispatchers.Main) {
                mBinding.tvInfo.append("Starting API call \n")
                val enqueueDeferredResponse = ApiClient.service.getUserDetails().enqueueDeferredResponse(this@RetrofitActivity, RetrofitCallback {
                    progressView = mBinding.progressBar

                    on200Ok { call, response ->
                        mBinding.tvInfo.append("Response received \n")
                    }
                })
                mBinding.tvInfo.append("API called \n")
                val response = enqueueDeferredResponse.await()
                mBinding.tvInfo.append("Response Await Call Completed \n")
                val body = response.body()
                mBinding.tvResponse.text = body.toString()
            }
        }


    }
}
