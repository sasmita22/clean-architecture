package com.hiroshisasmita.cleanarchitecture.data.repository

import androidx.paging.PagingData
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    suspend fun fetchPopularMovies(): Flow<PagingData<PopularMovieDomain>>

}