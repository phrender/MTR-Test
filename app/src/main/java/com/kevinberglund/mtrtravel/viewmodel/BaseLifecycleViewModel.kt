package com.kevinberglund.mtrtravel.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ILifecycleObserversHolder {

    fun provideLifecycleObservers(): LiveData<List<LifecycleObserverWrapper>> = MutableLiveData(listOf())
}

data class LifecycleObserverWrapper(val lifecycleObserver: LifecycleObserver, var addToLifecycle: Boolean = true)

abstract class BaseLifecycleViewModel : BaseViewModel(), ILifecycleObserversHolder, DefaultLifecycleObserver {

    override fun provideLifecycleObservers(): LiveData<List<LifecycleObserverWrapper>> = MutableLiveData(mutableListOf(LifecycleObserverWrapper(this)))
}