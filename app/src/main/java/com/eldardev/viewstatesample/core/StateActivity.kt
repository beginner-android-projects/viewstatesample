package com.eldardev.viewstatesample.core

import com.eldardev.viewstatesample.core.common.CommonActivity
import com.eldardev.viewstatesample.core.common.State
import com.eldardev.viewstatesample.core.common.StateEvent
import com.eldardev.viewstatesample.core.common.handleState

abstract class StateActivity<S : State> : CommonActivity(), StateEvent<S> {

    abstract val viewModel: StateViewModel<S>

    override fun onStart() {
        super.onStart()

        handleState(viewModel.state, {
            it?.let {
                onNewState(it)
            }
        })
    }
}