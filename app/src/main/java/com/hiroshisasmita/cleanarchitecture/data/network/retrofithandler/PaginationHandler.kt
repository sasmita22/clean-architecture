package com.hiroshisasmita.cleanarchitecture.data.network.retrofithandler

import com.hiroshisasmita.android_core.base.BaseRetrofitResponsePlainAdapter
import com.hiroshisasmita.cleanarchitecture.data.network.wrapper.PaginationResponseWrapper
import com.hiroshisasmita.cleanarchitecture.exception.ServerErrorException
import okhttp3.ResponseBody
import retrofit2.Response

class PaginationHandler<T: Any>: BaseRetrofitResponsePlainAdapter<PaginationResponseWrapper<T>, PaginationResponseWrapper<T>>() {
    override fun fetchSuccessData(data: PaginationResponseWrapper<T>): PaginationResponseWrapper<T> {
        return data
    }

    override fun fetchError(errorBody: ResponseBody, responseCode: Int): Exception {
        return try {
            val exception = when (responseCode) {
                in 500..599 -> ServerErrorException()
                else -> Exception()
            }
            exception
        } catch (exception: Exception) {
            exception
        }
    }
}

suspend fun <T: Any>Response<PaginationResponseWrapper<T>>.handleApi(): PaginationResponseWrapper<T>? {
    return PaginationHandler<T>().handleApi(this)
}
