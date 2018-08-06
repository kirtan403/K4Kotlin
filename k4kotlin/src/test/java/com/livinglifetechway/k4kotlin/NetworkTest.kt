package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application

/**
 * Tests functions related to networking
 */
@RunWith(RobolectricTestRunner::class)
class NetworkTest {

    /**
     * Test that [isNetworkAvailable] returns true.
     */
    @Test
    fun isNetworkAvailable() {
        assertTrue(application.isNetworkAvailable())
    }

}