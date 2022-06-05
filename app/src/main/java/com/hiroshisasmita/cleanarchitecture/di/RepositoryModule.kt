package com.hiroshisasmita.cleanarchitecture.di

import com.hiroshisasmita.cleanarchitecture.data.repository.IMovieRepository
import com.hiroshisasmita.cleanarchitecture.data.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMovieRepository(repo: MovieRepository): IMovieRepository
}