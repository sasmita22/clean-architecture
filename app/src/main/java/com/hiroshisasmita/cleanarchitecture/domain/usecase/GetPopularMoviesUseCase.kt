package com.hiroshisasmita.cleanarchitecture.domain.usecase

import androidx.paging.PagingData
import com.hiroshisasmita.android_core.base.domain.UseCase
import com.hiroshisasmita.cleanarchitecture.domain.repository.IMovieRepository
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import com.hiroshisasmita.cleanarchitecture.domain.usecase.GetPopularMoviesUseCase.RequestValues
import com.hiroshisasmita.cleanarchitecture.domain.usecase.GetPopularMoviesUseCase.ResponseValues
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repo: IMovieRepository
): UseCase<RequestValues, ResponseValues>() {

    class RequestValues: UseCase.RequestValues
    class ResponseValues(
        val paging: Flow<PagingData<PopularMovieDomain>>
    ): UseCase.ResponseValues

    override suspend fun execute(requestValues: RequestValues): ResponseValues {
        val result = repo.fetchPopularMovies()
        return ResponseValues(
            result
        )
    }
}