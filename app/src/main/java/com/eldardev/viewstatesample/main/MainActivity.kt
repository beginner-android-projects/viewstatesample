package com.eldardev.viewstatesample.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.eldardev.viewstatesample.R
import com.eldardev.viewstatesample.core.StateActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : StateActivity<MainState>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.clickOnButton()
        }
    }

    override val viewModel: MainViewModel by viewModels()

    override fun onNewState(state: MainState) {
        val mainText = findViewById<TextView>(R.id.textView)

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
}