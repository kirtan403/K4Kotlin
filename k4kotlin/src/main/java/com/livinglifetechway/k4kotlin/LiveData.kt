package com.livinglifetechway.k4kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.databinding.ObservableArrayList

/** Nicer syntax for [Transformations.map] **/
fun <X, Y> LiveData<X>.map(func: (X) -> Y?): LiveData<Y> = Transformations.map(this, func)

/** Nicer syntax for [Transformations.switchMap] **/
fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>?): LiveData<Y> = Transformations.switchMap(this, func)

/**
 * Converts a [LiveData] containing a [List] into an [ObservableArrayList].
 *
 * This is useful when using a [LiveData] as the data source for a RecyclerView adapter.
 **/
fun <T> LiveData<List<T>>.toObservableArrayList(): ObservableArrayList<T> {
    val list = ObservableArrayList<T>()
    this.observeForever {
        list.clear()
        val newList = it.orEmpty()
        list.addAll(newList)
    }
    return list
}