package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class StringTest {

    @Test
    fun isEmail_ReturnsTrue() {
        val email = "hello@example.com"

        assertTrue(email.isEmail())
    }

    @Test
    fun isEmail_ReturnsFalse() {
        val email = "Does this look like a damn email address to you?"

        assertFalse(email.isEmail())
    }

    @Test
    fun isNumeric_ReturnsTrue() {
        val string = "12342"

        assertTrue(string.isNumeric())
    }

    @Test
    fun isNumeric_ReturnsFalse() {
        val string = "There's more to maths than just numbers you know."

        assertFalse(string.isNumeric())
    }
}