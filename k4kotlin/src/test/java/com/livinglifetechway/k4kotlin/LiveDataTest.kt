package com.livinglifetechway.k4kotlin

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class LiveDataTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun liveData_Works() {
        val liveData = MutableLiveData<Int>()

        assertEquals(null, liveData.value)

        liveData.observeForever {}

        liveData.postValue(3)

        assertEquals(3, liveData.value)
    }

    @Test
    fun map_Works() {
        val original = MutableLiveData<Int>()

        assertEquals(null, original.value)

        val map = original.map { it * 3 }

        assertEquals(null, map.value)

        map.observeForever { }

        original.postValue(3)

        assertEquals(3, original.value)

        assertEquals(3 * 3, map.value)

    }

    @Test
    fun switchMap_Works() {
        val original = MutableLiveData<Int>()

        assertEquals(null, original.value)

        val switchMap = original.switchMap {
            MutableLiveData<Int>().apply { value = it * 7 }
        }

        assertEquals(null, switchMap.value)

        switchMap.observeForever { }

        original.postValue(9)

        assertEquals(9, original.value)

        assertEquals(9 * 7, switchMap.value)

    }

    @Test
    fun toObservableArrayList_Works() {
        val liveData = MutableLiveData<List<Int>>()

        assertEquals(null, liveData.value)

        val arrayList = liveData.toObservableArrayList()

        assertEquals(arrayList, emptyList<Int>())

        liveData.value = listOf(2, 3, 4)

        assertEquals(liveData.value, listOf(2, 3, 4))

        assertEquals(arrayList, listOf(2, 3, 4))
    }

}