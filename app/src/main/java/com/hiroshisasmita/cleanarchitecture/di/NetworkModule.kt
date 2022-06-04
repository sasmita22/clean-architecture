package com.hiroshisasmita.cleanarchitecture.di

import com.hiroshisasmita.cleanarchitecture.BuildConfig
import com.hiroshisasmita.cleanarchitecture.data.network.interceptor.DefaultInterceptor
import com.hiroshisasmita.cleanarchitecture.data.network.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @QualifierDefaultInterceptor
    fun providesDefaultInterceptor(): Interceptor {
        return DefaultInterceptor()
    }

    @Provides
    @QualifierLoggingInterceptor
    fun providesLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    fun providesClient(
        @QualifierDefaultInterceptor defaultInterceptor: Interceptor,
        @QualifierLoggingInterceptor loggingInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(defaultInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun providesMovieService(
        client: OkHttpClient
    ): MovieService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BuildConfig.MOVIE_BASE_URL)
            .build()
            .create(MovieService::class.java)
    }
}