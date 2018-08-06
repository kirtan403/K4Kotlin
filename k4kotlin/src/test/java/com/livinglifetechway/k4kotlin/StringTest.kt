package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Tests functions related to strings
 */
@RunWith(RobolectricTestRunner::class)
class StringTest {

    /**
     * Test that [isEmail] returns true when the given string is an email address
     */
    @Test
    fun isEmail_ReturnsTrue() {
        val email = "hello@example.com"

        assertTrue(email.isEmail())
    }

    /**
     * Test that [isEmail] returns false when the given string is not an email address
     */
    @Test
    fun isEmail_ReturnsFalse() {
        val email = "Does this look like a damn email address to you?"

        assertFalse(email.isEmail())
    }

    /**
     * Test that [isNumeric] returns true when the given string is numeric
     */
    @Test
    fun isNumeric_ReturnsTrue() {
        val string = "12342"

        assertTrue(string.isNumeric())
    }

    /**
     * Test that [isNumeric] returns false when the given string is not numeric
     */
    @Test
    fun isNumeric_ReturnsFalse() {
        val string = "There's more to maths than just numbers you know."

        assertFalse(string.isNumeric())
    }
}