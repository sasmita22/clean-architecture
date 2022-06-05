package com.hiroshisasmita.cleanarchitecture.domain.model

import com.hiroshisasmita.cleanarchitecture.data.network.response.PopularMovieResponseDTO


data class PopularMovieDomain (
    var id: String,
    var overview: String,
    var posterPath: String,
    var backdropPath: String,
    var releaseDate: String,
    var title: String,
    var voteAverage: Double
) {
    companion object {
        fun parse(dto: PopularMovieResponseDTO): PopularMovieDomain {
            return PopularMovieDomain (
                id = dto.id.toString(),
                overview = dto.overview.orEmpty(),
                posterPath = dto.posterPath.orEmpty(),
                backdropPath = dto.backdropPath.orEmpty(),
                releaseDate = dto.releaseDate.orEmpty(),
                title = dto.title.orEmpty(),
                voteAverage = dto.voteAverage ?: 0.toDouble()
            )
        }
    }
}