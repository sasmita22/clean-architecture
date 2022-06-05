package com.hiroshisasmita.cleanarchitecture.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.hiroshisasmita.android_core.extension.extLoadImage
import com.hiroshisasmita.cleanarchitecture.BuildConfig
import com.hiroshisasmita.cleanarchitecture.databinding.LayoutItemPopularMovieBinding
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomainDIffUtil

class PopularMovieAdapter: PagingDataAdapter<PopularMovieDomain, PopularMovieAdapter.ViewHolder>(PopularMovieDomainDIffUtil()) {

    inner class ViewHolder(
        private val binding: LayoutItemPopularMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: PopularMovieDomain) {
            binding.tvTitle.text = movie.title
            binding.ivImage.extLoadImage(
                "${BuildConfig.IMAGE_BASE_URL}${movie.backdropPath}",
                RequestOptions().centerCrop()
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemPopularMovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
}