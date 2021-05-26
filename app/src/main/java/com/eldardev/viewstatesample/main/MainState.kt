package com.eldardev.viewstatesample.main

import com.eldardev.viewstatesample.core.common.State

sealed class MainState : State {
    object SignedOut : MainState()
    object InProgress : MainState()
    data class Error(val error: String) : MainState()
    object SignedIn : MainState()
}