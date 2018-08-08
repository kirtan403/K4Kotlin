package com.livinglifetechway.k4kotlin

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.annotation.LayoutRes

/**
 * Sets the activity content by calling DataBindingUtil.setContentView
 */
fun <T : ViewDataBinding> Activity.setBindingView(@LayoutRes res: Int): T = DataBindingUtil.setContentView(this, res)