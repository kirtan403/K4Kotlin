package com.livinglifetechway.k4kotlin

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class ConversionsTest {

    @Test
    @Config(qualifiers = "ldpi")
    fun pxToDp_Ldpi() {
        assertEquals(64f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "ldpi")
    fun dpToPx_Ldpi() {
        assertEquals(48f, application.dpToPx(64f))
    }

    @Test
    @Config(qualifiers = "mdpi")
    fun pxToDp_Mdpi() {
        assertEquals(48f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "mdpi")
    fun dpToPx_Mdpi() {
        assertEquals(48f, application.dpToPx(48f))
    }

    @Test
    @Config(qualifiers = "hdpi")
    fun pxToDp_Hdpi() {
        assertEquals(32f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "hdpi")
    fun dpToPx_Hdpi() {
        assertEquals(48f, application.dpToPx(32f))
    }

    @Test
    @Config(qualifiers = "xhdpi")
    fun pxToDp_Xhdpi() {
        assertEquals(24f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "xhdpi")
    fun dpToPx_Xhdpi() {
        assertEquals(48f, application.dpToPx(24f))
    }

    @Test
    @Config(qualifiers = "xxhdpi")
    fun pxToDp_Xxhdpi() {
        assertEquals(16f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "xxhdpi")
    fun dpToPx_Xxhdpi() {
        assertEquals(48f, application.dpToPx(16f))
    }

    @Test
    @Config(qualifiers = "xxxhdpi")
    fun pxToDp_Xxxhdpi() {
        assertEquals(12f, application.pxToDp(48f))
    }

    @Test
    @Config(qualifiers = "xxxhdpi")
    fun dpToPx_Xxxhdpi() {
        assertEquals(48f, application.dpToPx(12f))
    }
}