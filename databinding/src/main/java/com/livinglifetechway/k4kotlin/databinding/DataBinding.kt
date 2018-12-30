package com.livinglifetechway.k4kotlin.databinding

import android.app.Activity
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Sets the activity's content view with the data binding
 * @param layoutRes Layout resource to use as the activity's content
 * @param bindingComponent optional
 * @return The ViewDataBinding instance of the specified type
 */
fun <T : ViewDataBinding> Activity.setBindingView(
        @LayoutRes layoutRes: Int,
        bindingComponent: DataBindingComponent? = null
) = DataBindingUtil.setContentView<T>(this, layoutRes, bindingComponent)

/**
 * Binds a view to specified view data binding
 * @return The ViewDataBinding instance of the specified type
 */
fun <T : ViewDataBinding> View.bind() = DataBindingUtil.bind<T>(this)

/**
 * Inflates the given the layout
 * You can do this inside fragment's onCreateView:
 * <code>
 *     val binding = parentView.bind(R.layout.fragment_hello_world)
 *     /* something awesome */
 *     return binding.root
 * </code>
 *
 * @param layoutRes layout resource to inflate
 * @param attachToParent weather to attach the inflated view to parent (Default false)
 * @return The ViewDataBinding instance of the specified type
 */
fun <T : ViewDataBinding> ViewGroup.bind(@LayoutRes layoutRes: Int, attachToParent: Boolean = false): T {
    return DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, this, attachToParent)
}