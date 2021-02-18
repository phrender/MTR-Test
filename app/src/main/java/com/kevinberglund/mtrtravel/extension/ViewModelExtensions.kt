package com.kevinberglund.mtrtravel.extension

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kevinberglund.mtrtravel.viewmodel.BaseLifecycleViewModel

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : BaseLifecycleViewModel> FragmentActivity.lifecycleAwareViewModel(
    crossinline  provider: () -> VM
) = lazy(LazyThreadSafetyMode.NONE) {
    ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
    }).get(VM::class.java).also { viewModel ->
        viewModel.provideLifecycleObservers().observe(this, Observer {
            it.forEach { observerWrapper ->
                if (observerWrapper.addToLifecycle) {
                    lifecycle.addObserver(observerWrapper.lifecycleObserver)
                } else {
                    lifecycle.removeObserver(observerWrapper.lifecycleObserver)
                }
            }
        })
    }
}