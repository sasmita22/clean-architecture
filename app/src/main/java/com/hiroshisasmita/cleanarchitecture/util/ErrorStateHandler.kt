package com.hiroshisasmita.cleanarchitecture.util

import android.app.Activity
import com.hiroshisasmita.android_core.exception.BadRequestException
import com.hiroshisasmita.android_core.exception.ServerErrorException
import com.hiroshisasmita.android_core.exception.UnauthorizedException
import com.hiroshisasmita.android_core.extension.extToast
import com.hiroshisasmita.cleanarchitecture.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorStateHandler {
    fun handleError(
        activity: Activity,
        throwable: Throwable,
        blockUnauthorized: (error: UnauthorizedException) -> Unit,
        blockBadRequest: (error: BadRequestException) -> Unit
    ) {
        with(activity) {
            when (throwable) {
                is UnauthorizedException -> blockUnauthorized.invoke(throwable)
                is UnknownHostException -> extToast(getString(R.string.no_internet_error_message))
                is SocketTimeoutException -> extToast(getString(R.string.no_internet_error_message))
                is BadRequestException -> blockBadRequest.invoke(throwable)
                is ServerErrorException -> extToast(getString(R.string.something_went_wrong_try_again_message))
                else -> extToast(getString(R.string.something_went_wrong_try_again_message))
            }
        }
    }
}