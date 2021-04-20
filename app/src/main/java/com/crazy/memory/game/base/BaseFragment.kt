package com.crazy.memory.game.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

abstract class BaseFragment (
    @LayoutRes private val layoutId: Int
) : Fragment(layoutId) {

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.tag(LOG_FRAGMENT_NAME_INFO).d(this::class.java.simpleName)

        setupView(savedInstanceState)
        setupObservers()
    }

    protected open fun setupView(savedInstanceState: Bundle?) {}

    protected open fun setupObservers() {}

    companion object {
        private const val LOG_FRAGMENT_NAME_INFO = "FRAGMENT_NAME"
    }
}