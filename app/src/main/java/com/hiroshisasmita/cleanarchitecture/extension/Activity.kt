package com.hiroshisasmita.cleanarchitecture.extension

import android.app.Activity
import com.hiroshisasmita.android_core.exception.BadRequestException
import com.hiroshisasmita.android_core.extension.extToast
import com.hiroshisasmita.cleanarchitecture.util.ErrorStateHandler

fun Activity.handleError(
        throwable: Throwable,
        blockHandleBadRequest: ((error: BadRequestException) -> Unit)
) {
    ErrorStateHandler.handleError(
        activity = this,
        throwable = throwable,
        blockUnauthorized = { extToast(it.message.orEmpty()) },
        blockBadRequest = blockHandleBadRequest
    )
}