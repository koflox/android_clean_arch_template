package com.koflox.cleanarch.ui.main

import android.os.Bundle
import com.koflox.cleanarch.R
import com.koflox.cleanarch.databinding.ActivityMainBinding
import com.koflox.cleanarch.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = getViewModel()

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel = viewModel
    }

}