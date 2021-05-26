package com.eldardev.viewstatesample.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.eldardev.viewstatesample.core.common.CommonFragment
import com.eldardev.viewstatesample.core.common.State
import com.eldardev.viewstatesample.core.common.StateEvent
import com.eldardev.viewstatesample.core.common.handleState

abstract class StateBindingFragment<ViewBindingType: ViewBinding, S: State> : CommonFragment(),
    StateEvent<S> {

    protected abstract val bindingInflater: (LayoutInflater) -> ViewBindingType

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: ViewBindingType
        get() = _binding as ViewBindingType

    abstract val viewModel : StateViewModel<S>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater)

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleState(viewModel.state, {
            it?.let {
                onNewState(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}