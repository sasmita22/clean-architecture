package com.hiroshisasmita.cleanarchitecture.data.network.interceptor

import com.hiroshisasmita.cleanarchitecture.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class DefaultInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.MOVIE_API_KEY)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}