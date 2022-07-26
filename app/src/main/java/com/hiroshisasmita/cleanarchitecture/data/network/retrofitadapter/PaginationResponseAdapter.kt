package com.hiroshisasmita.cleanarchitecture.data.network.retrofitadapter

import com.google.gson.reflect.TypeToken
import com.hiroshisasmita.android_core.base.data.adapter.BaseRetrofitResponsePlainAdapter
import com.hiroshisasmita.android_core.base.data.network.ResponseCode
import com.hiroshisasmita.cleanarchitecture.data.network.wrapper.PaginationResponseWrapper
import com.hiroshisasmita.android_core.exception.ServerErrorException
import com.hiroshisasmita.android_core.exception.UnauthorizedException
import com.hiroshisasmita.cleanarchitecture.data.network.response.ErrorResponse
import com.hiroshisasmita.cleanarchitecture.exception.MovieBadRequestException
import okhttp3.ResponseBody
import retrofit2.Response

class PaginationResponseAdapter<T: Any>: BaseRetrofitResponsePlainAdapter<PaginationResponseWrapper<T>, PaginationResponseWrapper<T>>() {
    override fun fetchSuccessData(data: PaginationResponseWrapper<T>): PaginationResponseWrapper<T> {
        return data
    }

    override fun fetchError(errorBody: ResponseBody, responseCode: Int): Exception {
        return try {
            val exception = when (responseCode) {
                ResponseCode.UNAUTHORIZED -> UnauthorizedException()
                ResponseCode.BAD_REQUEST -> {
                    handleBadRequestError(errorBody)
                }
                in 500..599 -> ServerErrorException()
                else -> Exception()
            }
            exception
        } catch (exception: Exception) {
            exception
        }
    }

    private fun handleBadRequestError(errorBody: ResponseBody): Exception {
        val type = object: TypeToken<ErrorResponse>(){}.type
        val errorWrapper = errorBody.errorBodyParser<ErrorResponse>(type)
        val errorMessage = errorWrapper?.statusMessage
        return MovieBadRequestException(errorMessage)
    }

    companion object {
        suspend fun <T: Any> handleApi(block: suspend () -> Response<PaginationResponseWrapper<T>>): PaginationResponseWrapper<T> {
            return PaginationResponseAdapter<T>().handleApi(block)
        }
    }
}
