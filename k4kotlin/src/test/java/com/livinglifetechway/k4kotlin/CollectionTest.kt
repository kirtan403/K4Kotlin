package com.livinglifetechway.k4kotlin

import org.junit.Assert.*
import org.junit.Test

class CollectionTest {

    @Test
    fun addIfNew_ShouldAddWhenNew() {
        val list = arrayListOf(20, 14, 34, 983)

        list.addIfNew(7)

        assertEquals(list, listOf(20, 14, 34, 983, 7))
    }

    @Test
    fun addIfNew_ShouldNotAddWhenNotNew() {
        val list = arrayListOf(20, 14, 34, 983)

        list.addIfNew(20)

        assertEquals(list, arrayListOf(20, 14, 34, 983))
    }

    @Test
    fun toggle_ShouldRemoveWhenPresent() {
        val list = arrayListOf(20, 14, 34, 983)

        list.toggle(20)

        assertEquals(list, listOf(14, 34, 983))
    }

    @Test
    fun toggle_ShouldAddNotPresent() {
        val list = arrayListOf(20, 14, 34, 983)

        list.toggle(7)

        assertEquals(list, listOf(20, 14, 34, 983, 7))
    }

    @Test
    fun doIfContained_ShouldDoIfContained() {
        val list = arrayListOf(20, 14, 34, 983)

        var done = false

        list.doIfContained(983) {
            done = true
        }

        assertTrue(done)
    }

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