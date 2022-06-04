package com.hiroshisasmita.cleanarchitecture.presentation.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.hiroshisasmita.android_core.base.BaseViewModelActivity
import com.hiroshisasmita.cleanarchitecture.databinding.ActivityMoviesBinding

class MoviesActivity : BaseViewModelActivity<MoviesViewModel, ActivityMoviesBinding>() {
    // region Intent
    companion object {
        fun newInstance(context: Context) {
            Intent(context, MoviesActivity::class.java).run {
                context.startActivity(this)
            }
        }
    }
    // endregion

    // region Property
    // endregion

    // region Initialization
    override val viewModel by viewModels<MoviesViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMoviesBinding
        get() = ActivityMoviesBinding::inflate
    // endregion

    // region Setup
    override fun setupViews() {

    }

    override fun setupObservers() {

    }
    // endregion

    // region HelperMethod
    // endregion
}