package com.livinglifetechway.k4kotlin

import android.widget.Toast
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application
import org.robolectric.Shadows.shadowOf

/**
 * Test functions related to toasts
 */
@RunWith(RobolectricTestRunner::class)
class ToastTest {

    private val shownToasts: List<Toast>
        get() = shadowOf(application).shownToasts

    /**
     * Display a toast and check it is shown
     */
    @Test
    fun normalToast() {
        val toast = application.toast("Ping!")
        assertTrue(shownToasts.contains(toast))
    }

    /**
     * Display a short toast and check it is shown
     */
    @Test
    fun shortToast() {
        val toast = application.shortToast("Pop!")
        assertTrue(shownToasts.contains(toast))
    }

    /**
     * Display a long toast and check it is shown
     */
    @Test
    fun longToast() {
        val toast = application.longToast("Paaaaaarp!")
        assertTrue(shownToasts.contains(toast))
    }

    /**
     * Display a toast to cancel the previous one and check it is shown
     */
    @Test
    fun normalToastNow() {
        application.toast("Hello!")
        val toast = application.toastNow("Surprise!")
        assertTrue(shownToasts.contains(toast))
    }

    /**
     * Display a short toast to cancel the previous one and check it is shown
     */
    @Test
    fun shortToastNow() {
        application.toast("How are you?")
        val toast = application.shortToastNow("Boo!")
        assertTrue(shownToasts.contains(toast))
    }

    /**
     * Display a long toast to cancel the previous one and check it is shown
     */
    @Test
    fun longToastNow() {
        application.toast("Not bad!")
        val toast = application.longToastNow("This is an unexpected message!")
        assertTrue(shownToasts.contains(toast))
    }




}