package com.eldardev.viewstatesample.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.eldardev.viewstatesample.core.common.CommonActivity
import com.eldardev.viewstatesample.core.common.State
import com.eldardev.viewstatesample.core.common.StateEvent
import com.eldardev.viewstatesample.core.common.handleState

abstract class StateBindingActivity<ViewBindingType: ViewBinding, S : State> : CommonActivity(),
    StateEvent<S> {

    abstract val viewModel: StateViewModel<S>

    protected abstract val bindingInflater: (LayoutInflater) -> ViewBindingType

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: ViewBindingType
        get() = _binding as ViewBindingType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater(layoutInflater)
        val view = _binding!!.root

        setContentView(view)
    }


    override fun onStart() {
        super.onStart()

        handleState(viewModel.state, {
            it?.let {
                onNewState(it)
            }
        })
    }
}