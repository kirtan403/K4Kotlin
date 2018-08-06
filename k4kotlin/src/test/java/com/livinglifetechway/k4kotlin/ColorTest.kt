package com.livinglifetechway.k4kotlin

import android.support.v4.content.ContextCompat
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application

/**
 * Tests methods related to color
 */
@RunWith(RobolectricTestRunner::class)
class ColorTest {

    /**
     * Tests that [getColorCompat] returns the correct color
     */
    @Test
    fun getColor_ReturnsColor() {
        val color = application.getColorCompat(R.color.material_grey_300)

        assertEquals(ContextCompat.getColor(application, R.color.material_grey_300), color)
    }

    /**
     * Tests that [getColorStateListCompat] returns the correct color state list
     */
    @Test
    fun getColorStateList_ReturnsColorStateList() {
        val colorStateList = application.getColorStateListCompat(R.color.material_blue_grey_800)

        assertEquals(ContextCompat.getColorStateList(application, R.color.material_blue_grey_800), colorStateList)
    }

}