package com.crazy.memory.game.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <reified T : Any?> LifecycleOwner.observe(
    liveData: LiveData<T>,
    crossinline execution: (T) -> Unit
) {
    liveData.observe(this, { value -> value?.apply(execution) })
}