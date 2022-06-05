package com.hiroshisasmita.cleanarchitecture.data.network.datasource

import com.hiroshisasmita.cleanarchitecture.data.network.query.PopularMovieQuery
import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO
import com.hiroshisasmita.cleanarchitecture.data.network.retrofithandler.handleApi
import com.hiroshisasmita.cleanarchitecture.data.network.service.MovieService
import com.hiroshisasmita.cleanarchitecture.data.network.wrapper.PaginationResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultRemoteDataSource @Inject constructor(
    private val api: MovieService
) : IRemoteDataSource {

    override suspend fun fetchPopularMovies(query: PopularMovieQuery): PaginationResponseWrapper<PopularMovieResponseDTO> =
        withContext(Dispatchers.IO) {
            return@withContext api.getPopularMovies(query.toMap()).handleApi()
                ?: PaginationResponseWrapper.defaultValue()
        }
}