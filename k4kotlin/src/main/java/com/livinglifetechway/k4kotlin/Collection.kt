package com.livinglifetechway.k4kotlin


/**
 * Adds an element to Collection if not already exists
 */
fun <T> MutableCollection<T>.addIfNew(t: T): Boolean = when {
    !contains(t) -> add(t)
    else -> false
}

/**
 * Adds an element to Collection if not already exists
 * @return true if added else false if removed
 */
fun <T> MutableCollection<T>.toggle(t: T): Boolean = when {
    !contains(t) -> {
        add(t)
        true
    }
    else -> {
        remove(t)
        false
    }
}

/**
 * Perform operation if item is there in the collection
 */
fun <T> Collection<T>.doIfContained(t: T, func: T.() -> Unit): Boolean {
    if (contains(t)) {
        t.func()
        return true
    }
    return false
}