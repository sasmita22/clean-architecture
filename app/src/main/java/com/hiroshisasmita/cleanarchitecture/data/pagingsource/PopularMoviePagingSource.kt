package com.hiroshisasmita.cleanarchitecture.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hiroshisasmita.cleanarchitecture.data.network.datasource.IRemoteDataSource
import com.hiroshisasmita.cleanarchitecture.data.network.query.PopularMovieQuery
import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO

class PopularMoviePagingSource(
    private val remoteDataSource: IRemoteDataSource
): PagingSource<Int, PopularMovieResponseDTO>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PopularMovieResponseDTO> {
        val currentPage = params.key ?: 1

        return try {
            val result = remoteDataSource.fetchPopularMovies(
                PopularMovieQuery(currentPage)
            )

            LoadResult.Page(
                data = result.results,
                prevKey = null,
                nextKey = currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PopularMovieResponseDTO>): Int? = null
}
