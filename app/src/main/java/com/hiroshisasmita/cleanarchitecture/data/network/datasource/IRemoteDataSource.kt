package com.hiroshisasmita.cleanarchitecture.data.network.datasource

import com.hiroshisasmita.cleanarchitecture.data.network.query.PopularMovieQuery
import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO
import com.hiroshisasmita.cleanarchitecture.data.network.wrapper.PaginationResponseWrapper

interface IRemoteDataSource {

    suspend fun fetchPopularMovies(query: PopularMovieQuery): PaginationResponseWrapper<PopularMovieResponseDTO>
}