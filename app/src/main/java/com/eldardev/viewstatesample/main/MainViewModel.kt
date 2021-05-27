package com.eldardev.viewstatesample.main

import com.eldardev.viewstatesample.core.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainUseCase: MainUseCase, val str: String) : StateViewModel<MainState>() {

    override fun initState(): MainState  = MainState.SignedOut

    fun clickOnButton(){
        setState(MainState.Error(str))

        mainUseCase.test()
    }
}