package com.eldardev.viewstatesample.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.eldardev.viewstatesample.R
import com.eldardev.viewstatesample.core.StateActivity
import com.eldardev.viewstatesample.core.StateBindingActivity
import com.eldardev.viewstatesample.databinding.ActivityMainBinding

class MainActivity2 : StateBindingActivity<ActivityMainBinding,  MainState>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.clickOnButton()
        }
    }

    override val viewModel: MainViewModel by viewModels()

    override fun onNewState(state: MainState) {
        val mainText = binding.textView

        when(state){
            is MainState.SignedOut -> {
                mainText.text = "SignedOut"
            }
            is MainState.InProgress -> {
                mainText.text = "InProgress"
            }
            is MainState.Error -> {
                mainText.text = state.error
            }
            is MainState.SignedIn -> {
                mainText.text = "SignedIn"
            }
        }
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}