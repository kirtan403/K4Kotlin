package com.livinglifetechway.k4kotlin

import org.junit.Assert.*
import org.junit.Test

/**
 * Test functions related to collections
 */
class CollectionTest {

    /**
     * Tests that the [addIfNew] method does add an element to a list if it isn't already a member
     */
    @Test
    fun addIfNew_ShouldAddWhenNew() {
        val list = arrayListOf(20, 14, 34, 983)

        list.addIfNew(7)

        assertEquals(list, listOf(20, 14, 34, 983, 7))
    }

    /**
     * Tests that the [addIfNew] method doesn't add an element to a list if it is already a member
     */
    @Test
    fun addIfNew_ShouldNotAddWhenNotNew() {
        val list = arrayListOf(20, 14, 34, 983)

        list.addIfNew(20)

        assertEquals(list, arrayListOf(20, 14, 34, 983))
    }

    /**
     * Tests that the [toggle] method removes an item from a list if it is present
     */
    @Test
    fun toggle_ShouldRemoveWhenPresent() {
        val list = arrayListOf(20, 14, 34, 983)

        list.toggle(20)

        assertEquals(list, listOf(14, 34, 983))
    }

    /**
     * Tests that the [toggle] method adds an item from a list if it is not present
     */
    @Test
    fun toggle_ShouldAddNotPresent() {
        val list = arrayListOf(20, 14, 34, 983)

        list.toggle(7)

        assertEquals(list, listOf(20, 14, 34, 983, 7))
    }

    /**
     * Tests that [doIfContained] executes its callback when the given list contains the given value
     */
    @Test
    fun doIfContained_ShouldDoIfContained() {
        val list = arrayListOf(20, 14, 34, 983)

        var done = false

        list.doIfContained(983) {
            done = true
        }

        assertTrue(done)
    }

    /**
     * Tests that [doIfContained] does not execute its callback if the given list does not contain the given value
     */
    @Test
    fun doIfContained_ShouldNotDoIfNotContained() {
        val list = arrayListOf(20, 14, 34, 983)

        var done = false

        list.doIfContained(7) {
            done = true
        }

        assertFalse(done)
    }
}