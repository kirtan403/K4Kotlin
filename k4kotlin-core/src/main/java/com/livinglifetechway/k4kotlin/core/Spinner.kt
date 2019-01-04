package com.livinglifetechway.k4kotlin.core

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter

/**
 * Callback when spinner item is selected
 * @param onNothingSelect callback to execute when nothing is selected
 * @param onItemSelect callback to execute when an item is selected
 * @return returns an instance of onItemSelectedListener
 */
fun Spinner.onItemSelected(
        onNothingSelect: (parent: AdapterView<*>?) -> Unit = { _ -> },
        onItemSelect: (parent: AdapterView<*>?, view: View?, position: Int?, id: Long?) -> Unit = { _, _, _, _ -> }): AdapterView.OnItemSelectedListener {

    val itemSelected = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
            onNothingSelect(p0)
        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            onItemSelect(p0, p1, p2, p3)
        }

    }

    onItemSelectedListener = itemSelected
    return itemSelected
}

/**
 * Sets ArrayList of objects with an additional string conversion method for objects
 * @param items list of objects
 * @param layoutResource layout resource to use to bind the item to
 * @param getTitle function to execute on each items to properly converts a list of objects to list of strings
 * @return An instance of SpinnerAdapter
 */
fun <T> Spinner.setItems(
        items: ArrayList<T>?,
        layoutResource: Int = android.R.layout.simple_spinner_dropdown_item,
        getTitle: (item: T) -> String = { a -> a.toString() }): SpinnerAdapter? {

    val finalList: ArrayList<String> = ArrayList()
    items?.forEach {
        finalList.add(getTitle(it))
    }

    val myAdapter = ArrayAdapter(this.context, layoutResource, finalList)
    adapter = myAdapter

    return adapter
}

