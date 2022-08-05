package com.hiroshisasmita.cleanarchitecture.domain.repository

import androidx.paging.PagingData
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    suspend fun fetchPopularMovies(): Flow<PagingData<PopularMovieDomain>>

}