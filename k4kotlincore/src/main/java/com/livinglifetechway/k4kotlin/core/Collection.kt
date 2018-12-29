package com.livinglifetechway.k4kotlin.core


/**
 * Adds an element to Collection if not already exists
 * @receiver MutableCollection
 * @param T an element to add if not already present
 * @return boolean value representing if the element is added or not
 */
fun <T> MutableCollection<T>.addIfNew(t: T): Boolean = when {
    !contains(t) -> add(t)
    else -> false
}

/**
 * Adds an element to Collection if not already exists
 * @receiver MutableCollection
 * @param T an element to add if not already present and remove if already present
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
 * @receiver Collection
 * @param T an element to check if exists in the collection
 * @param func to execute if t is present in the collection
 * @return true if added else false if removed
 */
fun <T> Collection<T>.doIfContained(t: T, func: T.() -> Unit): Boolean {
    if (contains(t)) {
        t.func()
        return true
    }
    return false
}