package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application

@RunWith(RobolectricTestRunner::class)
class NetworkTest {

    @Test
    fun isNetworkAvailable() {
        assertTrue(application.isNetworkAvailable())
    }

}