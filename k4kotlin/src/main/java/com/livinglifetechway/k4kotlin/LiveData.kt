package com.livinglifetechway.k4kotlin

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations

/** Nicer syntax for [Transformations.map] **/
fun <X, Y> LiveData<X>.map(func: (X) -> Y?): LiveData<Y> = Transformations.map(this, func)

/** Nicer syntax for [Transformations.switchMap] **/
fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>?): LiveData<Y> = Transformations.switchMap(this, func)