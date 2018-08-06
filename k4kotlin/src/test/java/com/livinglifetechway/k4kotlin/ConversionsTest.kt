package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application
import org.robolectric.annotation.Config

/**
 * Tests methods related to DP/PX conversion
 */
@RunWith(RobolectricTestRunner::class)
class ConversionsTest {

    /**
     * Test that [pxToDp] is correct for low-dpi devices
     */
    @Test
    @Config(qualifiers = "ldpi")
    fun pxToDp_Ldpi() {
        assertEquals(64f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for low-dpi devices
     */
    @Test
    @Config(qualifiers = "ldpi")
    fun dpToPx_Ldpi() {
        assertEquals(48f, application.dpToPx(64f))
    }

    /**
     * Test that [pxToDp] is correct for medium-dpi devices
     */
    @Test
    @Config(qualifiers = "mdpi")
    fun pxToDp_Mdpi() {
        assertEquals(48f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for medium-dpi devices
     */
    @Test
    @Config(qualifiers = "mdpi")
    fun dpToPx_Mdpi() {
        assertEquals(48f, application.dpToPx(48f))
    }

    /**
     * Test that [pxToDp] is correct for high-dpi devices
     */
    @Test
    @Config(qualifiers = "hdpi")
    fun pxToDp_Hdpi() {
        assertEquals(32f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for high-dpi devices
     */
    @Test
    @Config(qualifiers = "hdpi")
    fun dpToPx_Hdpi() {
        assertEquals(48f, application.dpToPx(32f))
    }

    /**
     * Test that [pxToDp] is correct for extra-high-dpi devices
     */
    @Test
    @Config(qualifiers = "xhdpi")
    fun pxToDp_Xhdpi() {
        assertEquals(24f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for extra-high-dpi devices
     */
    @Test
    @Config(qualifiers = "xhdpi")
    fun dpToPx_Xhdpi() {
        assertEquals(48f, application.dpToPx(24f))
    }

    /**
     * Test that [pxToDp] is correct for extra-extra-dpi devices
     */
    @Test
    @Config(qualifiers = "xxhdpi")
    fun pxToDp_Xxhdpi() {
        assertEquals(16f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for extra-extra-dpi devices
     */
    @Test
    @Config(qualifiers = "xxhdpi")
    fun dpToPx_Xxhdpi() {
        assertEquals(48f, application.dpToPx(16f))
    }

    /**
     * Test that [pxToDp] is correct for extra-extra-extra-dpi devices
     */
    @Test
    @Config(qualifiers = "xxxhdpi")
    fun pxToDp_Xxxhdpi() {
        assertEquals(12f, application.pxToDp(48f))
    }

    /**
     * Test that [dpToPx] is correct for extra-extra-extra-dpi devices
     */
    @Test
    @Config(qualifiers = "xxxhdpi")
    fun dpToPx_Xxxhdpi() {
        assertEquals(48f, application.dpToPx(12f))
    }
}