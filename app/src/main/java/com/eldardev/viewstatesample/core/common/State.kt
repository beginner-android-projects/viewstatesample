package com.eldardev.viewstatesample.core.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface State

interface StateEvent<S: State>{
    fun onNewState(state: S)
}

fun <S : State, L : LiveData<S>> LifecycleOwner.handleState(liveData: L, body: (S?) -> Unit) =
    liveData.observe(this, Observer(body))