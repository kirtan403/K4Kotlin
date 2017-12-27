package com.livinglifetechway.k4kotlinsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livinglifetechway.k4kotlin.setBindingView
import com.livinglifetechway.k4kotlin.show
import com.livinglifetechway.k4kotlin.toast
import com.livinglifetechway.k4kotlin_retrofit.*
import com.livinglifetechway.k4kotlinsample.RetrofitApi.ApiClient
import com.livinglifetechway.k4kotlinsample.databinding.ActivityRetrofitBinding
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class RetrofitActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = setBindingView(R.layout.activity_retrofit)

//        runBlocking {
//            val job = launch(UI) {
//                val enqueueAwait = ApiClient.service.getUserDetails().enqueueAwait(this@RetrofitActivity, RetrofitCallback {
//                    progressView = mBinding.progressBar
//
//                    on200Ok { call, response ->
//                        get original response object
//                    }
//                })
//                mBinding.tvResponse.text = enqueueAwait.toString()
//            }
//        }
//        mBinding.tvInfo.text = "This is runblocking"


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
            })
            mBinding.tvInfo.append("API call enqueued \n")
        }

        // enqueue await
        mBinding.btnEnqueueAwait.setOnClickListener {
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            async(UI) {
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

            val asyncTask = async(UI) {
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

            async(UI) {
                asyncTask.join()
                // you can check the state of the coroutine
                if (asyncTask.isCompletedExceptionally) toast("Exception")
            }
        }



        mBinding.btnEnqueueAwaitRunblocking.setOnClickListener {
            mBinding.progressBar.show()
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            runBlocking {
                launch(UI) {
                    mBinding.tvInfo.append("Starting API call \n")
                    val enqueueAwait = ApiClient.service.getUserDetails().enqueueAwait(this@RetrofitActivity, RetrofitCallback {
                        progressView = mBinding.progressBar

                        on200Ok { call, response ->
                            mBinding.tvInfo.append("Response received \n")
                        }
                    })
                    mBinding.tvInfo.append("Await call completed \n")
                    mBinding.tvResponse.text = enqueueAwait.toString()
                }
            }
            mBinding.tvInfo.append("Run Blocking completed \n")
        }
//
        // deferred response body
        mBinding.btnEnqueueDeferred.setOnClickListener {
            mBinding.progressBar.show()
            mBinding.tvResponse.text = ""
            mBinding.tvInfo.text = ""

            async(UI) {
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

            async(UI) {
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
