package com.eldardev.viewstatesample.main

import com.eldardev.viewstatesample.core.StateViewModel

class MainViewModel : StateViewModel<MainState>() {

    override fun initState(): MainState  = MainState.SignedOut

    fun clickOnButton(){
        setState(MainState.Error("my error"))
    }
}