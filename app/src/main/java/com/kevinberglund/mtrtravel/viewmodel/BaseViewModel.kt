package com.kevinberglund.mtrtravel.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val disposables = mutableListOf<IDisposable>()

    internal fun addDisposable(disposable: IDisposable) {
        disposables.add(disposable)
    }

    @CallSuper
    public override fun onCleared() {
        disposables.forEach { it.dispose() }
        disposables.clear()
    }
}