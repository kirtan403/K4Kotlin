package com.livinglifetechway.k4kotlin.core

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Converts the timestamp in millis to date
 * @return Date object with the given timestamp in millis
 */
fun Long.toDate(): Date = Date(this)

/**
 * Gets the calendar instance with the given timestamp in millis
 * @return Calendar instance with the give timestamp in millis
 */
fun Long.toCalendar(): Calendar = Calendar.getInstance().apply { timeInMillis = this@toCalendar }

/**
 * Converts the timestamp to relative time string
 * @return Returns the relative time span string
 */
fun Long.getRelativeTimeSpanString() = DateUtils.getRelativeTimeSpanString(this)


/**
 * Formats the calendar instance to the given output date format
 * @param format Date format excepted by SimpleDateFormat
 * @param locale An optional locale instance to consider while formatting date
 * @return A formatted date string
 */
fun Calendar.format(format: String, locale: Locale = Locale.US) = SimpleDateFormat(format, locale).format(time)


/**
 * Formats the date instance to the given output date format
 * @param format Date format excepted by SimpleDateFormat
 * @param locale An optional locale instance to consider while formatting date
 * @return A formatted date string
 */
fun Date.format(format: String, locale: Locale = Locale.US) = SimpleDateFormat(format, locale).format(this)

/**
 * Formats the timestamp to the given output date format
 * @param format Date format excepted by SimpleDateFormat
 * @param locale An optional locale instance to consider while formatting date
 * @return A formatted date string
 */
fun Long.formatToDate(format: String, locale: Locale = Locale.US) = SimpleDateFormat(format, locale).format(this.toDate())