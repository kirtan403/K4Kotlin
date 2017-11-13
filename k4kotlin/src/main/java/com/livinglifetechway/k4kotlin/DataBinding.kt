package com.livinglifetechway.k4kotlin

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes

/**
 * Sets the activity content by calling DataBindingUtil.setContentView
 */
fun <T : ViewDataBinding> Activity.setBindingView(@LayoutRes res: Int): T = DataBindingUtil.setContentView(this, res)