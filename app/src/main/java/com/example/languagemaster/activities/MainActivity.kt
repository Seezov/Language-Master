package com.example.languagemaster.activities

import android.os.Bundle
import com.example.languagemaster.R
import com.example.languagemaster.viewmodels.MainViewModel

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
