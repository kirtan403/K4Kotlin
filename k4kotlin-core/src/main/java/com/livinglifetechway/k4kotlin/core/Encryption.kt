package com.livinglifetechway.k4kotlin.core

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * Get encrypted string.
 */
private fun encrypt(string: String?, type: String): String {
    if (string.isNullOrEmpty()) return ""

    val messageDigest: MessageDigest
    return try {
        messageDigest = MessageDigest.getInstance(type)
        val bytes = messageDigest.digest(string.toByteArray())
        bytes2Hex(bytes)
    } catch (e: NoSuchAlgorithmException) {
        ""
    }
}

/**
 * Converts byteArray to String.
 */
private fun bytes2Hex(bts: ByteArray): String {
    var des = ""
    var tmp: String
    for (i in bts.indices) {
        tmp = Integer.toHexString(bts[i].toInt() and 0xFF)
        if (tmp.length == 1) {
            des += "0"
        }
        des += tmp
    }
    return des
}


/**
 * Generates md5 hash for the given string
 */
fun String.md5() = encrypt(this, "MD5")

/**
 * Generates sha1 hash for the given string
 */
fun String.sha1() = encrypt(this, "SHA-1")