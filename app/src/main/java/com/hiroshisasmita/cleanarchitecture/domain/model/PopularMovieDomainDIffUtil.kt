package com.hiroshisasmita.cleanarchitecture.domain.model

import androidx.recyclerview.widget.DiffUtil

class PopularMovieDomainDIffUtil : DiffUtil.ItemCallback<PopularMovieDomain>() {
    override fun areItemsTheSame(
        oldItem: PopularMovieDomain,
        newItem: PopularMovieDomain
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PopularMovieDomain,
        newItem: PopularMovieDomain
    ): Boolean {
        return oldItem.id == newItem.id
    }

}