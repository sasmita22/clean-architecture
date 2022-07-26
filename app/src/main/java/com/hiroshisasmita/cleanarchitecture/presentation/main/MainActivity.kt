package com.hiroshisasmita.cleanarchitecture.presentation.main

import android.view.LayoutInflater
import com.hiroshisasmita.android_core.base.presentation.BaseActivity
import com.hiroshisasmita.cleanarchitecture.databinding.ActivityMainBinding
import com.hiroshisasmita.cleanarchitecture.presentation.movies.MoviesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setupViews() {
        binding.btNext.setOnClickListener {
            MoviesActivity.newInstance(this@MainActivity)
        }
    }

    // region Intent
    // endregion

    // region Property
    // endregion

    // region Initialization
    // endregion

    // region Setup
    // endregion

    // region HelperMethod
    // endregion
}