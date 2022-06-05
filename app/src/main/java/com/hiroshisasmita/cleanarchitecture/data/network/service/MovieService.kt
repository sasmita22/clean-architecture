package com.hiroshisasmita.cleanarchitecture.data.network.service

import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO
import com.hiroshisasmita.cleanarchitecture.data.network.wrapper.PaginationResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @QueryMap query: HashMap<String, @JvmSuppressWildcards Any>
    ): Response<PaginationResponseWrapper<PopularMovieResponseDTO>>
}