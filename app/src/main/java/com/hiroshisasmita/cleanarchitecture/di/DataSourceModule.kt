package com.hiroshisasmita.cleanarchitecture.di

import com.hiroshisasmita.cleanarchitecture.data.network.datasource.DefaultRemoteDataSource
import com.hiroshisasmita.cleanarchitecture.data.network.datasource.IRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindsDefaultRemoteDataSource(dataSource: DefaultRemoteDataSource): IRemoteDataSource

}