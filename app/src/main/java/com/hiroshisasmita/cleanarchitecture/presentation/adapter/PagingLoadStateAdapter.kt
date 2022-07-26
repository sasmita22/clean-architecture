package com.hiroshisasmita.cleanarchitecture.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hiroshisasmita.cleanarchitecture.databinding.LayoutPagingLoadStateBinding

class PagingLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PagingLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutPagingLoadStateBinding
            .inflate(inflater, parent, false)
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bindView()
    }

    inner class LoadStateViewHolder(private val binding: LayoutPagingLoadStateBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView() {
            binding.pbLoadState.isVisible = loadState is LoadState.Loading
            binding.btRetry.isVisible = loadState !is LoadState.Loading
            binding.btRetry.setOnClickListener { retry.invoke() }
        }
    }
}