package com.eldardev.viewstatesample.core

import android.os.Bundle
import android.view.View
import com.eldardev.viewstatesample.core.common.CommonFragment
import com.eldardev.viewstatesample.core.common.State
import com.eldardev.viewstatesample.core.common.StateEvent
import com.eldardev.viewstatesample.core.common.handleState

abstract class StateFragment<S: State> : CommonFragment(), StateEvent<S> {

    abstract val viewModel : StateViewModel<S>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleState(viewModel.state, {
            it?.let {
                onNewState(it)
            }
        })
    }
}