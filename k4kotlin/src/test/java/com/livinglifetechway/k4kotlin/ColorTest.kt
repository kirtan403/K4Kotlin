package com.livinglifetechway.k4kotlin

import android.support.v4.content.ContextCompat
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application

@RunWith(RobolectricTestRunner::class)
class ColorTest {

    @Test
    fun getColor_ReturnsColor() {
        val color = application.getColorCompat(R.color.material_grey_300)

        assertEquals(ContextCompat.getColor(application, R.color.material_grey_300), color)
    }

    @Test
    fun getColorStateList_ReturnsColorStateList() {
        val colorStateList = application.getColorStateListCompat(R.color.material_blue_grey_800)

        assertEquals(ContextCompat.getColorStateList(application, R.color.material_blue_grey_800), colorStateList)
    }

}