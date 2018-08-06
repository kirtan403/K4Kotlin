package com.livinglifetechway.k4kotlin

import android.Manifest
import android.content.Context
import android.support.annotation.RequiresPermission
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat

/**
 * Checks the device's hardware and software configuration to determine whether fingerprint scanning is available
 */
@get:RequiresPermission(Manifest.permission.USE_FINGERPRINT)
val Context.isFingerprintAvailable: Boolean
    get() {
        val fingerprintManager = FingerprintManagerCompat.from(this)
        return with(fingerprintManager) {
            isHardwareDetected && hasEnrolledFingerprints()
        }
    }