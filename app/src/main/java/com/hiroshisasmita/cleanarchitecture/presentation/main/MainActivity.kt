package com.hiroshisasmita.cleanarchitecture.presentation.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hiroshisasmita.android_core.base.BaseActivity
import com.hiroshisasmita.cleanarchitecture.databinding.ActivityMainBinding
import com.hiroshisasmita.cleanarchitecture.databinding.ActivityMoviesBinding
import com.hiroshisasmita.cleanarchitecture.presentation.movies.MoviesActivity
import com.hiroshisasmita.cleanarchitecture.presentation.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setupViews() {
        lifecycleScope.launch {
            delay(500)
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