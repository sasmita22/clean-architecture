package com.hiroshisasmita.cleanarchitecture.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.hiroshisasmita.cleanarchitecture.data.network.datasource.IRemoteDataSource
import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO
import com.hiroshisasmita.cleanarchitecture.data.pagingsource.PopularMoviePagingSource
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource
): IMovieRepository {
    override suspend fun fetchPopularMovies(): Flow<PagingData<PopularMovieDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 1, enablePlaceholders = false),
            pagingSourceFactory = {
                PopularMoviePagingSource(
                    remoteDataSource = remoteDataSource
                )
            }
        ).flow.map { pagingData ->
                pagingData.map { PopularMovieDomain.parse(it) }
            }
    }
}