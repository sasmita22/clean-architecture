package com.hiroshisasmita.cleanarchitecture.exception

/**
 * BadRequestException is thrown when api response code is 400
 * @param message The message from error response payload
 * @param time The time to wait to re-request again in order to make it succeed
 * @param message is nullable
 * @param message if null, it must be set with default message in ui layer
 */
class BadRequestException(override val message: String? = null, val time: Long? = null): Exception(message)