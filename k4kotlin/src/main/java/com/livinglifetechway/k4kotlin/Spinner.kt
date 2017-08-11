package com.livinglifetechway.k4kotlin

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

/**
 * Spinner methods for on item select
 */

fun Spinner.OnItemSelected(
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
 */
fun Spinner.setItems(
        arrayList: ArrayList<*>?,
        function: (item: Any) -> String = { a -> a.toString() }) {

    val finalList: ArrayList<String> = ArrayList<String>()
    arrayList?.forEach {
        finalList.add(function(it))
    }

    val myAdapter = ArrayAdapter(this.context, android.R.layout.simple_spinner_dropdown_item, finalList)
    adapter = myAdapter

}

