package com.eldardev.viewstatesample.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eldardev.viewstatesample.core.common.CommonViewModel
import com.eldardev.viewstatesample.core.common.State

abstract class StateViewModel<S : State> : CommonViewModel() {
    internal val state: LiveData<S>
        get() = _state

    private val _state: MutableLiveData<S> =
        MutableLiveData<S>().apply {
            this.value = initState()
        }

    abstract fun initState(): S

    protected fun setState(state: S){
        _state.value = state
    }
}