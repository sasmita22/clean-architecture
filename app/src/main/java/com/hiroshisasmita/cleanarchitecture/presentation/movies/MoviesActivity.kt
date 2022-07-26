package com.hiroshisasmita.cleanarchitecture.presentation.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.hiroshisasmita.android_core.base.presentation.BaseViewModelActivity
import com.hiroshisasmita.android_core.extension.extToast
import com.hiroshisasmita.cleanarchitecture.databinding.ActivityMoviesBinding
import com.hiroshisasmita.cleanarchitecture.extension.handleError
import com.hiroshisasmita.cleanarchitecture.presentation.adapter.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    private val adapter: PopularMovieAdapter by lazy {
        PopularMovieAdapter()
    }

    private val loadStateListener = { loadState: CombinedLoadStates ->
        val isDataEmpty = loadState.source.refresh is LoadState.NotLoading && adapter.itemCount == 0
        val isLoading  = loadState.source.refresh is LoadState.Loading
        val isError = loadState.source.refresh is LoadState.Error

        binding.rvMovie.isVisible = !isDataEmpty && !isLoading && !isError
        binding.tvEmpty.isVisible = isDataEmpty && !isLoading && !isError
        binding.btRetry.isVisible = isError && !isLoading
        binding.pbLoading.isVisible = isLoading

        val errorState = loadState.source.append as? LoadState.Error
            ?: loadState.source.prepend as? LoadState.Error
            ?: loadState.append as? LoadState.Error
            ?: loadState.prepend as? LoadState.Error
            ?: loadState.source.refresh as? LoadState.Error
        if (errorState != null) {
            handleError(errorState.error) { error ->
                extToast(error.message.orEmpty())
            }
        }
    }

    // endregion

    // region Initialization
    override val viewModel by viewModels<MoviesViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMoviesBinding
        get() = ActivityMoviesBinding::inflate
    // endregion

    // region Setup
    override fun setupViews() = with (binding) {
        rvMovie.adapter = adapter.also {
            it.addLoadStateListener(loadStateListener)
            it.withLoadStateFooter(PagingLoadStateAdapter() {
                onRetry()
            })
        }

        srlMovies.setOnRefreshListener {
            viewModel.fetchPopularMovies()
        }
    }

    private fun onRetry() {
        adapter.retry()
    }

    override fun setupObservers() {
        viewModel.movies.observe(this) {
            adapter.submitData(lifecycle, it)
            binding.srlMovies.isRefreshing = false
        }
    }
    // endregion

    // region HelperMethod
    // endregion
}