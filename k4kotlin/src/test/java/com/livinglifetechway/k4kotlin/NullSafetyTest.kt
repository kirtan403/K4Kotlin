package com.livinglifetechway.k4kotlin

import org.junit.Assert.*
import org.junit.Test

class NullSafetyTest {

    @Test
    fun numberOrZero_ReturnsNumber() {
        val number: Number? = 2

        assertEquals(2, number.orZero())
    }

    @Test
    fun numberOrZero_ReturnsZeroWhenNull() {
        val number: Number? = null

        assertEquals(0, number.orZero())
    }

    @Test
    fun intOrZero_ReturnsInt() {
        val number: Int? = 2

        assertEquals(2, number.orZero())
    }

    @Test
    fun intOrZero_ReturnsZeroWhenNull() {
        val number: Int? = null

        assertEquals(0, number.orZero())
    }

    @Test
    fun longOrZero_ReturnsInt() {
        val number: Long? = 2L

        assertEquals(2L, number.orZero())
    }

    @Test
    fun longOrZero_ReturnsZeroWhenNull() {
        val number: Long? = null

        assertEquals(0L, number.orZero())
    }

    @Test
    fun floatOrZero_ReturnsInt() {
        val number: Float? = 2.3f

        assertEquals(2.3f, number.orZero())
    }

    @Test
    fun floatOrZero_ReturnsZeroWhenNull() {
        val number: Float? = null

        assertEquals(0f, number.orZero())
    }

    @Test
    fun doubleOrZero_ReturnsInt() {
        val number: Double? = 2.9

        assertEquals(2.9, number.orZero(), 0.0)
    }

    @Test
    fun doubleOrZero_ReturnsZeroWhenNull() {
        val number: Double? = null

        assertEquals(0.0, number.orZero(), 0.0)
    }

    @Test
    fun booleanOrFalse_ReturnsTrue() {
        val boolean: Boolean? = true

        assertTrue(boolean.orFalse())
    }

    @Test
    fun booleanOrTrue_ReturnsFalse() {
        val boolean: Boolean? = false

        assertFalse(boolean.orFalse())
    }

    @Test
    fun booleanOrTrue_ReturnsFalseWhenNull() {
        val boolean: Boolean? = null

        assertFalse(boolean.orFalse())
    }
}