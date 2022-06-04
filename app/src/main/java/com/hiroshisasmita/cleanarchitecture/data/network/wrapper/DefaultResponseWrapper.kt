package com.hiroshisasmita.cleanarchitecture.data.network.wrapper

import com.google.gson.annotations.SerializedName

data class PaginationResponseWrapper<T>(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("results") val results: T? = null
)
