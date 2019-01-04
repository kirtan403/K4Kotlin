package com.livinglifetechway.k4kotlinsample.retrofit

import com.livinglifetechway.k4kotlinsample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://reqres.in/api/"
    private var retrofit: Retrofit? = null

    // add logging interceptor if DEBUG build
    private val client: Retrofit?
        get() {
            if (retrofit == null) {
                val builder = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                if (BuildConfig.DEBUG) {
                    val client = OkHttpClient.Builder()
                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    client.addInterceptor(loggingInterceptor)
                    builder.client(client.build())
                }

                retrofit = builder.build()
            }
            return retrofit
        }

    val service: ApiInterface
        get() = client!!.create(ApiInterface::class.java)


}
