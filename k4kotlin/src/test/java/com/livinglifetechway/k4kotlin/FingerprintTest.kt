package com.livinglifetechway.k4kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application

@RunWith(RobolectricTestRunner::class)
class FingerprintTest {

    @Test
    fun fingerprint_IsEnabled() {
        application.isFingerprintAvailable
    }

}